package com.midominio.spring02.app.services;

import java.util.List;

import com.midominio.spring02.app.models.entities.Tienda;

public interface TiendasService {
	List<Tienda> listar();
	Tienda findById (Long id);
	List<Tienda> findByTipo(String tipo);
	void delete(Long id);
	void save(Tienda tienda);
}
