package com.midominio.spring02.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.midominio.spring02.app.models.entities.Articulo;

public interface ArticuloDao extends PagingAndSortingRepository<Articulo, Long>, CrudRepository<Articulo, Long>{
	
    List<Articulo> findByTipo(String tipo);
    List<Articulo> findByMarca(String marca);
    Page<Articulo> findByTipo(Pageable pageable, String tipo);
    Page<Articulo> findByMarca(Pageable pageable, String tipo);
    
    
    
    

	/* Notas para dejar ver el camino recorrido
	List<Articulo> listar(); 
	Articulo findById (Long id);
	List<Articulo> findByTipo(String tipo);
	List<Articulo> findByMarca(String marca);
	void delete(Long id);
	void save(Articulo articulo);
	*/
}
