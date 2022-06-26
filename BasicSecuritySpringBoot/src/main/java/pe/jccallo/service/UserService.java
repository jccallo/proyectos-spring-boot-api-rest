package pe.jccallo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.jccallo.model.User;
import pe.jccallo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		// otra forma de retornar una lista de usuarios
		List<User> users = new ArrayList<User>();  
		userRepository.findAll().forEach(user -> users.add(user));  
		return users;
		// return (List<User>) userRepository.findAll(); // mas corta
	}
	
	public User insert(User user) {
		Optional<User> userModel = userRepository.findByEmail(user.getEmail());
		if (!userModel.isPresent()) {
			return userRepository.save(user); //  save() retorna la entidad guardada
		}
		return null;
	}
	
	public User update(User user) {
		return userRepository.save(user); //  save() retorna la entidad guardada pero no se usa
	}
	
	public boolean delete(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}	
	
	public Optional<User> findById(Long id){
		return userRepository.findById(id);
	}

	// metodo alternativo
	public User getById(Long id){
		return userRepository.findById(id).get(); // obtiene el valor que es la entidad o ? 
		// return userRepository.findById(id); // la entidad o optional#empty
		// return userRepository.findById(id).orElse(null); // la entidad o null
	}
		
	public boolean validateById(Long id) {
		Optional<User> userModel = userRepository.findById(id);
		if(userModel.isPresent()) {
			return true;
		}
		else {
			return false;		
		}
	}
}
