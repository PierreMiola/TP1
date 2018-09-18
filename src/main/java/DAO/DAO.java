package DAO;

import java.io.Serializable;

import javax.persistence.EntityManager;

public abstract class DAO<T extends Serializable> {
	public EntityManager manager;
	
	public DAO(EntityManager em) {
		this.manager=em;
	}
	
	public abstract T find(long id);
	public abstract T create(T object);
	public abstract void delete(T object);
}
