package DAO;

import java.io.Serializable;

import javax.persistence.EntityManager;

import TAA.TP1.Lieu;
import TAA.TP1.Sport;

public class SportDAO extends DAO{
	
	public SportDAO(EntityManager em) {
		super(em);
	}

	@Override
	public Serializable find(long id) {
		//return (Sport) manager.createQuery("select s from Sport s where s.id=:id", Sport.class).setParameter("id", id).getSingleResult();
		return manager.find(Sport.class, id);
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
