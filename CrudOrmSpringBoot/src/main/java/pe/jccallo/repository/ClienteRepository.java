package pe.jccallo.repository;

import org.springframework.data.repository.CrudRepository;

import pe.jccallo.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
