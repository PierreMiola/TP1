package TAA.TP1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Lieu implements Serializable{
	private Long id;
	private String name;
	private List<Sport> sports;
	
	public Lieu() {
		this.sports=new ArrayList<Sport>();
	}
	
	public Lieu(String n) {
		this.name=n;
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
	public List<Sport> getSport() {
		return sports;
	}
	
	public void setSport(List<Sport> sl1) {
		this.sports = sl1;
	}
	
	public void addSport(Sport s) {
		this.sports.add(s);
	}
}
