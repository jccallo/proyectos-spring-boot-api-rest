package pe.jccallo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jccallo.entity.Login;
import pe.jccallo.entity.Saraos;
import pe.jccallo.service.SaraosService;

@RestController
@RequestMapping("/saraos")
public class SaraosRestController {
	@Autowired
	private SaraosService saraosService;
	
	@PostMapping("/listar")
	public ResponseEntity<?> listar_GET(@RequestBody Login login) {
		String username = login.getUsername();
		String password = login.getPassword();
		
		if((username.equals("octavio"))&&(password.equals("o123"))) {
			return new ResponseEntity<>(saraosService.findAll(),HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Acceso denegado!",HttpStatus.UNAUTHORIZED);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Saraos saraos)
	{
		saraosService.insert(saraos);
		return new ResponseEntity<>("¡Saraos registrado!", HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar_PUT(@RequestBody Saraos saraos)
	{
		Saraos saraosModel = saraosService.findById(saraos.getSaraosId());
		
		if (saraosModel != null) {
			saraosModel.setNombre(saraos.getNombre());
			
			saraosService.update(saraosModel);
			return new ResponseEntity<>("¡Saraos actualizado!", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Saraos no actualizado!", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{saraosId}")
	public ResponseEntity<?> borrar_DELETE(@PathVariable Integer saraosId)
	{
		Saraos saraosModel = saraosService.findById(saraosId);
		
		if (saraosModel != null) {
			saraosService.delete(saraosId);
			return new ResponseEntity<>("¡Saraos borrardo!", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Saraos no borrado!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{saraosId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer saraosId)
	{
		Saraos saraosModel = saraosService.findById(saraosId);
		
		if (saraosModel != null) {
			return new ResponseEntity<>(saraosModel, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("¡Saraos no encontrado!", HttpStatus.NOT_FOUND);
	}
}
