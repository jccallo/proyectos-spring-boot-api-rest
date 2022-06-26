package pe.jccallo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pe.jccallo.model.Telefono;

public interface TelefonoRepository extends CrudRepository<Telefono, Long> {
	Optional<Telefono> findByPrimerTelefono(String primerTelefono);
}
