package com.midominio.spring02.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.spring02.app.models.dao.ArticuloDao;
import com.midominio.spring02.app.models.entities.Articulo;

@Service
public class ArticulosServiceImpl implements ArticulosService {
	
	@Autowired
	ArticuloDao articuloDao;

	/*
	@Override
	@Transactional(readOnly = true)
	public List<Articulo> listar() {
		return articuloDao.listar();
	}
	*/
	
	@Override
	@Transactional(readOnly = true)
	public List<Articulo> listar() {
		return (List<Articulo>) articuloDao.findAll();
	}

	
	/*
	@Override
	@Transactional(readOnly = true)
	public Articulo findById(Long id) {
		return articuloDao.findById(id);
	}
	*/
	
	@Override
	@Transactional(readOnly = true)
	public Articulo findById(Long id) {
		return articuloDao.findById(id).orElse(null);
	}

	
	
	/*
	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findByTipo(String tipo) {
		return articuloDao.findByTipo(tipo);
	}
	*/
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findByTipo(String tipo) {
		return articuloDao.findByTipo(tipo);
	}
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Articulo> findByMarca(String marca) {
		// TODO Auto-generated method stub
		return articuloDao.findByMarca(marca);
	}
	
	/*
	@Override
	@Transactional
	public void delete(Long id) {
		articuloDao.delete(id);
	}
	*/
	
	@Override
	@Transactional
	public void delete(Long id) {
		articuloDao.deleteById(id);
	}

	@Override
	@Transactional
	public void save(Articulo articulo) {
		articuloDao.save(articulo);
	}

}
