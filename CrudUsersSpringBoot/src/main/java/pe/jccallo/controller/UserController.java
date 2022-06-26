package pe.jccallo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jccallo.model.User;
import pe.jccallo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@PostMapping()
	public User insert(@RequestBody User user) {
		return userService.insert(user);
	}
	
	@GetMapping(path="/{id}")
	public Optional<User> findById(@PathVariable("id") Long id){
		return userService.findById(id);
	}	
	
	@DeleteMapping(path="/{id}")
	public String delete(@PathVariable("id") Long id) {
		boolean res = userService.delete(id);
		if (res) {
			return "ELIMINO EL REGISTRO CON ID => " + id;
		}
		else {
			return "IMPOSIBLE ELIMINAR EL REGISTRO....!";
		}
	}	
	
	@PutMapping()
	public String update(@RequestBody User user) {
		// si queremos usar alguna validacion
		boolean userValidated = userService.validateById(user.getId()); 
		
		if (userValidated) {
			// recuperamos al usuario desde la base de datos
			User userModel = userService.getById(user.getId());
			
			// si se pasa un usuario con algun campo nulo
			// hacemos que se setee con el valor respectivo del usuario que se recupero
			if(user.getName() == null) 
				user.setName(userModel.getName());
			if(user.getEmail() == null) 
				user.setEmail(userModel.getEmail());
			if(user.getPassword() == null) 
				user.setPassword(userModel.getPassword());
			
			// actualizamos
			userService.update(user);
			
			// retornamos un mensaje
			return "Se Actualizaron los datos correctamente...!";
		}
		else {
			return "No Existe el Registro con ID => " + user.getId();
		}
	}
}
