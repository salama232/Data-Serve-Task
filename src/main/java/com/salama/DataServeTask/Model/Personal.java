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
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Personal") 
public class Personal  {


	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String Name;
	@Column
	private String Email;
	@Column
	private int Age;
	@Column
	private int Company_Id;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade =CascadeType.ALL,
            mappedBy = "personal")
    private Set<Company> company = new HashSet<>();

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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getCompany_Id() {
		return Company_Id;
	}

	public void setCompany_Id(int company_Id) {
		Company_Id = company_Id;
	}

}
