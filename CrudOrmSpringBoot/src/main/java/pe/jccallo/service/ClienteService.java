package pe.jccallo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.jccallo.model.Cliente;
import pe.jccallo.repository.ClienteRepository;
import pe.jccallo.repository.TelefonoRepository;

@Service
public class ClienteService {
	@Autowired
	private TelefonoRepository telefonoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	public Cliente insert(Cliente cliente) {
		telefonoRepository.save(cliente.getTelefono());
		return clienteRepository.save(cliente);
		
		/*
		Optional<Telefono> telefonoModel = telefonoRepository.findById(cliente.getTelefono().getId());
		if (!telefonoModel.isPresent()) {
			telefonoRepository.save(cliente.getTelefono());
			return clienteRepository.save(cliente);
		}
		return null;*/
	}
}
