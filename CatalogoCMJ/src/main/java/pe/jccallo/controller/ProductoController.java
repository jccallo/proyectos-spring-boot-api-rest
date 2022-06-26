package pe.jccallo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jccallo.model.Producto;
import pe.jccallo.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping()
	public List<Producto> findAll(){
		return productoService.findAll();
	}
	
	@GetMapping("/lista")
	public List<Object[]> findAllProductosSinValorizado(){
		return productoService.findAllProductosSinValorizado();
	}
	
	@GetMapping("/valorizado")
	public List<Object[]> findAllProductosConValorizado(){
		return productoService.findAllProductosConValorizado();
	}
	
	@PostMapping()
	public Producto insert(@RequestBody Producto producto) {
		return productoService.insert(producto);
	}	
	
	@PutMapping()
	public Producto update(@RequestBody Producto producto) {
		return productoService.update(producto);
	}	
}
