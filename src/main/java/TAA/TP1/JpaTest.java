package TAA.TP1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DAO.LieuDAO;
import DAO.PersonneDAO;
import DAO.SportDAO;

public class JpaTest {
	
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createPersonne();
			
			LieuDAO ld = new LieuDAO(manager);
			ld.create(new Lieu("Lyon"));
			
			System.out.println("**************************************");
			System.out.println(((Lieu) ld.find(2)).getName());
			System.out.println("**************************************");
		
			ld.delete((Lieu) ld.find(3));
			
			
			
			PersonneDAO pd = new PersonneDAO(manager);
			pd.create(new Personne("Jean Michel"));
			
			System.out.println("**************************************");
			System.out.println(((Personne) pd.find(2)).getName());
			System.out.println("**************************************");
		
			pd.delete((Personne) pd.find(3));
			
			
			
			SportDAO sd = new SportDAO(manager);
			sd.create(new Sport("judo"));
			
			System.out.println("**************************************");
			System.out.println(((Sport) sd.find(2)).getName());
			System.out.println("**************************************");
		
			sd.delete((Sport) sd.find(4));
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		test.listPersonne();
		
		manager.close();
		factory.close();
	}
	
	private void createPersonne() {
		int numOfPersonne = manager.createQuery("Select a From Personne a", Personne.class).getResultList().size();
		if (numOfPersonne == 0) {
			List<Sport> sl1 = new ArrayList<Sport>();
			List<Sport> sl2 = new ArrayList<Sport>();
			List<Lieu> ll1 = new ArrayList<Lieu>();
			List<Lieu> ll2 = new ArrayList<Lieu>();
			Lieu lieu1 = new Lieu("Rennes");
			Lieu lieu2 = new Lieu("Paris");
			Sport sport1 = new Sport("Football");
			Sport sport2 = new Sport("Basketball");
			lieu1.setSport(sl1);
			lieu2.setSport(sl2);
			manager.persist(sport1);
			manager.persist(sport2);
			manager.persist(lieu1);
			manager.persist(lieu2);
			sl1.add(sport1);
			sl2.add(sport2);
			ll1.add(lieu1);
			ll1.add(lieu2);
			ll2.add(lieu2);
			Personne p1 = new Personne("Jakab Gipsz");
			p1.setSport(sl1);
			p1.setLieu(ll1);
			Personne p2 = new Personne("Captain Nemo");
			p2.setSport(sl2);
			p2.setLieu(ll2);
			manager.persist(p1);
			manager.persist(p2);
			Sport s3 = new Sport("ping-pong");
			manager.persist(s3);
		}
	}

	private void listPersonne() {
		ArrayList<Personne> resultList = (ArrayList<Personne>) manager.createQuery("Select a From Personne a", Personne.class).getResultList();
		System.out.println("num of personne:" + resultList.size());
		for (Personne next : resultList) {
			System.out.println("next employee: " + next);
		}
	}
}

