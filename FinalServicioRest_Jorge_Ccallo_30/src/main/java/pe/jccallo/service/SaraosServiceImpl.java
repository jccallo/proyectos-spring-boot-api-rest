package pe.jccallo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.jccallo.entity.Saraos;
import pe.jccallo.repository.SaraosRepository;

@Service
public class SaraosServiceImpl implements SaraosService {
	
	@Autowired
	private SaraosRepository saraosRepository;
	
	@Override
	@Transactional
	public void insert(Saraos saraos) {
		saraosRepository.save(saraos);
	}

	@Override
	@Transactional
	public void update(Saraos saraos) {
		saraosRepository.save(saraos);
	}

	@Override
	@Transactional
	public void delete(Integer saraosId) {
		saraosRepository.deleteById(saraosId);
	}

	@Override
	@Transactional(readOnly = true)
	public Saraos findById(Integer saraosId) {
		return saraosRepository.findById(saraosId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Saraos> findAll() {
		return saraosRepository.findAll();
	}
}
