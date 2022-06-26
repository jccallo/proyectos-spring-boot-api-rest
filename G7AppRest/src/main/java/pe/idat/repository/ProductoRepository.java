package pe.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.idat.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
}
