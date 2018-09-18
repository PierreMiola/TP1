package DAO;

import java.io.Serializable;

import javax.persistence.EntityManager;

import TAA.TP1.Lieu;

public class LieuDAO extends DAO{
	
	public LieuDAO(EntityManager em) {
		super(em);
	}
	
	@Override
	public Serializable find(long id) {
		//return (Lieu) manager.createQuery("select l from Lieu l where l.id=:id", Lieu.class).setParameter("id", id).getSingleResult();
		return manager.find(Lieu.class, id);
	}

	public void delete(Serializable object) {
		manager.remove(object);
	}

	@Override
	public Serializable create(Serializable object) {
		manager.persist(object);
		return object;
	}
}
