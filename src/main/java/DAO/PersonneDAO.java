package DAO;

import java.io.Serializable;

import javax.persistence.EntityManager;

import TAA.TP1.Lieu;
import TAA.TP1.Personne;

public class PersonneDAO extends DAO{

	public PersonneDAO(EntityManager em) {
		super(em);
	}

	@Override
	public Serializable find(long id) {
		//return (Personne) manager.createQuery("select p from Personne p where p.id=:id", Personne.class).setParameter("id", id).getSingleResult();
		return manager.find(Personne.class, id);
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
