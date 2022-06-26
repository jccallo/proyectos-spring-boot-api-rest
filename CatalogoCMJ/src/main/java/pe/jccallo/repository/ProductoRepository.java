package pe.jccallo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pe.jccallo.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto,Long> {
	public static final String sql = "select id, nombre, descripcion, preciocompra, stock, round(preciocompra * stock) as valorizado from productos"; 
	@Query(value = sql, nativeQuery = true) 
	public List<Object[]> findAllProductosConValorizado();
	
	public static final String sinValorizado = "select id, nombre, descripcion, precioventa, stock from productos"; 
	@Query(value = sinValorizado, nativeQuery = true) 
	public List<Object[]> findAllProductosSinValorizado();
}
