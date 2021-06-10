package com.salama.DataServeTask.Model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Company") 
public class Company implements Runnable {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String Name;


	@ManyToMany(fetch = FetchType.LAZY,
	             cascade=CascadeType.ALL)
	    @JoinTable(name = "company_personal",
	            joinColumns = { @JoinColumn(name = "Company_id",referencedColumnName="id") },
	            inverseJoinColumns = { @JoinColumn(name = "Personal_id",referencedColumnName="id") })
	    private Set<Personal> personal = new HashSet<>();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	 public Set<Personal> getPersonal() {
		return personal;
	}

	public void setPersonal(Set<Personal> personal) {
		this.personal = personal;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
