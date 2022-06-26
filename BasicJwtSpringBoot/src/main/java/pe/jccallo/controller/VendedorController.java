package pe.jccallo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jccallo.model.Vendedor;
import pe.jccallo.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping()
	public List<Vendedor> findAll() {
		return vendedorService.findAll();
	}
	
	@PostMapping()
	public Vendedor insert(@RequestBody Vendedor vendedor) {
		return vendedorService.insert(vendedor);
	}
	
	@PutMapping()
	public Vendedor update(@RequestBody Vendedor vendedor) {
		Vendedor vendedorModel = vendedorService.findByCodigo(vendedor.getCodigo());
		if(vendedor.getNombre() == null) 
			vendedor.setNombre(vendedorModel.getNombre());
		if(vendedor.getApellido() == null) 
			vendedor.setApellido(vendedorModel.getApellido());
		if(vendedor.getTelefono() == null) 
			vendedor.setTelefono(vendedorModel.getTelefono());
		return vendedorService.update(vendedor);
	}	
	
	@DeleteMapping(path="/{codigo}")
	public Boolean delete(@PathVariable("codigo") Long codigo) {
		return vendedorService.delete(codigo);
	}	

	@GetMapping(path="/{codigo}")
	public Vendedor findByCodigo(@PathVariable("codigo") Long codigo){
		return vendedorService.findByCodigo(codigo);
	}
	
	@GetMapping(path="/telefono/{telefono}")
	public Vendedor findByTelefono(@PathVariable("telefono") String telefono){
		return vendedorService.findByTelefono(telefono);
	}
}
