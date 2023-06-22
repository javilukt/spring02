package com.midominio.spring02.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midominio.spring02.app.models.entities.Articulo;

public interface ArticulosService {
	List<Articulo> listar(); 
	// Añadir este, e importar de Spring Data Domain
	Page<Articulo> listar(Pageable pageable);
	Articulo findById (Long id);
	List<Articulo> findByTipo(String tipo);
	Page<Articulo> findByTipo(Pageable pageable, String tipo);
	List<Articulo> findByMarca(String marca);
	Page<Articulo> findByMarca(Pageable pageable, String marca);
	void delete(Long id);
	void save(Articulo articulo);
}
