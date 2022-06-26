package pe.jccallo.repository;

import org.springframework.data.repository.CrudRepository;

import pe.jccallo.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto,Long> {

}
