package com.midominio.spring02.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.midominio.spring02.app.models.entities.Articulo;
import com.midominio.spring02.app.models.entities.Tienda;

public interface TiendaDao extends CrudRepository<Tienda, Long>{
	
    List<Tienda> findByTipo(String marca);
	
	/*
	List<Tienda> listar();
	Tienda findById (Long id);
	List<Tienda> findByTipo(String tipo);
	void delete(Long id);
	void save(Tienda tienda);
	*/
}

