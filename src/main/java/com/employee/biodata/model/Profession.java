package com.employee.biodata.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Profession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String professionName;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<EmployeeDetails> employeeDetails = new HashSet<>();
 
	public Profession() {
	}

	public Profession(String professionName, Set<EmployeeDetails> employeeDetails) {
		this.professionName = professionName;
		this.employeeDetails = employeeDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	@Override
	public String toString() {
		return "Profession [id=" + id + ", professionName=" + professionName + ", employeeDetails=" + employeeDetails
				+ "]";
	}
}