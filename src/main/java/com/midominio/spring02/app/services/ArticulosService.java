package com.midominio.spring02.app.services;

import java.util.List;

import com.midominio.spring02.app.models.entities.Articulo;

public interface ArticulosService {
	List<Articulo> listar(); 
	Articulo findById (Long id);
	List<Articulo> findByTipo(String tipo);
	List<Articulo> findByMarca(String marca);
	void delete(Long id);
	void save(Articulo articulo);
}
