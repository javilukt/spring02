package com.midominio.spring02.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.spring02.app.models.dao.TiendaDao;
import com.midominio.spring02.app.models.entities.Tienda;

@Service
public class TiendasServiceImpl implements TiendasService {
	
	@Autowired
	TiendaDao tiendaDao;

	/*
	
	@Override
	@Transactional(readOnly = true)
	public List<Tienda> listar() {
		return tiendaDao.listar();
	}

	*/

	@Override
	@Transactional(readOnly = true)
	public List<Tienda> listar() {
		return (List<Tienda>) tiendaDao.findAll();
	}

	/*
	@Override
	@Transactional(readOnly = true)
	public Tienda findById(Long id) {		
		return tiendaDao.findById(id);
	}
	*/

	@Override
	@Transactional(readOnly = true)
	public Tienda findById(Long id) {		
		return tiendaDao.findById(id).orElse(null);
	}
	
	/*
	@Override
	@Transactional(readOnly = true)
	public List<Tienda> findByTipo(String tipo) {
		return tiendaDao.findByTipo(tipo);
	}
	*/
	
	@Override
	@Transactional(readOnly = true)
	public List<Tienda> findByTipo(String tipo) {
		return tiendaDao.findByTipo(tipo);
	}

	/*
	@Override
	@Transactional
	public void delete(Long id) {
		tiendaDao.delete(id);
	}
	*/
	
	@Override
	@Transactional
	public void delete(Long id) {
		tiendaDao.deleteById(id);
	}
	
	/*
	@Override
	@Transactional
	public void save(Tienda tienda) {
		tiendaDao.save(tienda);
	}
	*/
	
	@Override
	@Transactional
	public void save(Tienda tienda) {
		tiendaDao.save(tienda);
	}
	
}
