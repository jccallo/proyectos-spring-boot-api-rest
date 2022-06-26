package pe.jccallo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.jccallo.model.Categoria;
import pe.jccallo.model.Producto;
import pe.jccallo.repository.CategoriaRepository;
import pe.jccallo.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Producto> findAll() {
		return (List<Producto>) productoRepository.findAll();
	}
	
	public Producto insert(Producto producto) {
		Optional<Categoria> categoriaModel = categoriaRepository.findById(producto.getCategoria().getId());
		if(categoriaModel.isPresent()) {
			return productoRepository.save(producto);
		}
		return null;
		
		/*
		Optional<Categoria> categoriaModel = categoriaRepository.findById(producto.getCategoria().getId());
		if(!categoriaModel.isPresent()) {
			categoriaRepository.save(producto.getCategoria());
		}
		return productoRepository.save(producto);*/
	}
}
