package com.employee.biodata.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Title {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<EmployeeDetails> employeeDetails = new HashSet<>();

	public Title() {
	}
	
	public Title(String title, Set<EmployeeDetails> employeeDetails) {
		this.title = title;
		this.employeeDetails = employeeDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Title [id=" + id + ", title=" + title + ", employeeDetails=" + employeeDetails + "]";
	}
}