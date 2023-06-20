package com.midominio.spring02.app.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.midominio.spring02.app.models.entities.Articulo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ArticuloDaoImpl implements ArticuloDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Articulo> listar() {
		return em.createQuery("from Articulo", Articulo.class).getResultList();
	}
	
	@Override
	public Articulo findById(Long id) {
		return em.find(Articulo.class, id);
	}
	
	@Override
	public List<Articulo> findByTipo(String tipo) {
		return em.createQuery("FROM Articulo a WHERE a.tipo = '" + tipo +"'", Articulo.class).getResultList();
	}
	
	@Override
	public List<Articulo> findByMarca(String marca) {
		return em.createQuery("FROM Articulo a WHERE a.marca = '" + marca +"'", Articulo.class).getResultList();
	}

	@Override
	public void delete(Long id) {
		em.remove(findById(id));
	}

	@Override
	public void save(Articulo articulo) {
		if (articulo.getId() != null && articulo.getId() > 0)
			// actualiza
			em.merge(articulo);
		else
			// inserta
			em.persist(articulo);
	}
	
}
