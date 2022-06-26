package pe.jccallo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pe.jccallo.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	// podemos crear nuevos metodos para obetener un usuario
	// no solo usaremos findById y otros metodos que trae CrudRepository
	Optional<User> findByEmail(String email);
}
