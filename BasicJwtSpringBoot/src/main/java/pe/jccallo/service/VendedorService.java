package pe.jccallo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.jccallo.model.Vendedor;
import pe.jccallo.repository.VendedorRepository;

@Service
public class VendedorService {
	@Autowired
	private VendedorRepository vendedorRepository;
	
	public List<Vendedor> findAll(){
		return (List<Vendedor>) vendedorRepository.findAll();
	}
	
	public Vendedor insert(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	
	public Vendedor update(Vendedor vendedor) {
		Optional<Vendedor> vendedorModel = vendedorRepository.findByCodigo(vendedor.getCodigo());
		if (vendedorModel.isPresent()) {
			return vendedorRepository.save(vendedor);
		}
		return null;
	}
	
	public boolean delete(Long codigo) {
		try {
			vendedorRepository.deleteById(codigo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}	
	
	public Vendedor findByCodigo(Long codigo){
		return vendedorRepository.findByCodigo(codigo).orElse(null);
	}
	
	public Vendedor findByTelefono(String telefono){
		return vendedorRepository.findByTelefono(telefono).orElse(null);
	}
}

