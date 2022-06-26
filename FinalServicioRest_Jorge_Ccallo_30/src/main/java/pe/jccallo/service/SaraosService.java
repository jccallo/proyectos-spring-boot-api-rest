package pe.jccallo.service;

import java.util.Collection;

import pe.jccallo.entity.Saraos;

public interface SaraosService {
	public abstract void insert(Saraos saraos);
	public abstract void update(Saraos saraos);
	public abstract void delete(Integer saraosId);
	public abstract Saraos findById(Integer saraosId);
	public abstract Collection<Saraos> findAll();
}
