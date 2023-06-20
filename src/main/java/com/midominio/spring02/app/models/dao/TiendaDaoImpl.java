package com.midominio.spring02.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.midominio.spring02.app.models.entities.Tienda;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TiendaDaoImpl implements TiendaDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Tienda> listar() {
		return em.createQuery("from Tienda", Tienda.class).getResultList();
	}
	@Override
	public Tienda findById(Long id) {	
		return em.find(Tienda.class, id);
	}
	
	@Override
	public List<Tienda> findByTipo(String tipo) {	
		return em.createQuery("FROM Tienda t WHERE t.tipo = '" + tipo +"'", Tienda.class).getResultList();
	}	

	@Override
	public void delete(Long id) {
		em.remove(findById(id));
	}
	

	@Override
	public void save(Tienda tienda) {
		if (tienda.getId() != null && tienda.getId() > 0)
			// actualiza
			em.merge(tienda);
		else
			// inserta
			em.persist(tienda);
	}
}
