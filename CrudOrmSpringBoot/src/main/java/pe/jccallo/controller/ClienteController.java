package pe.jccallo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.jccallo.model.Cliente;
import pe.jccallo.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping()
	public List<Cliente> findAll(){
		return clienteService.findAll();
	}
	
	@PostMapping()
	public Cliente insert(@RequestBody Cliente cliente) {
		return clienteService.insert(cliente);
	}
}
