package pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.entity.Login;
import pe.idat.entity.Producto;
import pe.idat.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController 
{
	@Autowired
	private ProductoService productoService;
	
	@PostMapping("/listar")
	public ResponseEntity<?> listar_GET(@RequestBody Login login) 
	{
		String username=login.getUsername();
		String password=login.getPassword();
		
		if((username.equals("octavio"))&&(password.equals("o123"))) {
			return new ResponseEntity<>(productoService.findAll(),HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Acceso denegado!",HttpStatus.UNAUTHORIZED);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Producto producto)
	{
		productoService.insert(producto);
		return new ResponseEntity<>("¡Producto registrado!",HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar_PUT(@RequestBody Producto producto)
	{
		Producto productoModel = productoService.findById(producto.getProductoId());
		
		if (productoModel != null) {
			productoModel.setNombre(producto.getNombre());
			productoModel.setMarca(producto.getMarca());
			productoModel.setPrecio(producto.getPrecio());
			
			productoService.update(productoModel);
			return new ResponseEntity<>("¡Producto actualizado!", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Producto no encontrado!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{productoId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer productoId)
	{
		Producto productoModel = productoService.findById(productoId);
		
		if (productoModel != null) {
			productoService.delete(productoId);
			return new ResponseEntity<>("¡Producto borrardo!", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Producto no encontrado!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{productoId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer productoId)
	{
		Producto productoModel = productoService.findById(productoId);
		
		if (productoModel != null) {
			return new ResponseEntity<>(productoModel, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Producto no encontrado!", HttpStatus.NOT_FOUND);
	}
	
	//tarea como practiando para tu examen final
	//EDITAR
	//BORRAR
	//BUSCAR
	//Memoria y BD
}
