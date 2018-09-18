package TAA.TP1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Personne implements Serializable{
	private Long id;
	private String name;
	private List<Lieu> lieux;
	private List<Sport> sports;
	
	public Personne() {
		this.lieux=new ArrayList<Lieu>();
		this.sports=new ArrayList<Sport>();
	}
	
	public Personne(String n) {
		this.name=n;
		this.lieux=new ArrayList<Lieu>();
		this.sports=new ArrayList<Sport>();
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	public List<Lieu> getLieu() {
		return lieux;
	}
	
	public void setLieu(List<Lieu> l) {
		this.lieux = l;
	}
	
	@ManyToMany
	public List<Sport> getSport() {
		return sports;
	}
	
	public void setSport(List<Sport> s) {
		this.sports = s;
	}

}
