package com.midominio.spring02.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.midominio.spring02.app.models.entities.Articulo;
import com.midominio.spring02.app.models.entities.Tienda;

public interface ArticuloDao extends CrudRepository<Articulo, Long>{
	
    List<Articulo> findByTipo(String tipo);
    List<Articulo> findByMarca(String marca);

	/*
	List<Articulo> listar(); 
	Articulo findById (Long id);
	List<Articulo> findByTipo(String tipo);
	List<Articulo> findByMarca(String marca);
	void delete(Long id);
	void save(Articulo articulo);
	*/
}
