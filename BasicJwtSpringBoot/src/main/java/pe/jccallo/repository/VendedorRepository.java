package pe.jccallo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pe.jccallo.model.Vendedor;

public interface VendedorRepository extends CrudRepository<Vendedor, Long> {
	Optional<Vendedor> findByCodigo(Long codigo);
	Optional<Vendedor> findByTelefono(String telefono);
}
