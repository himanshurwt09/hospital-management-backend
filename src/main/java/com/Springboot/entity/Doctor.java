package com.Springboot.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,length = 100)
	private  String name;
	
	@Column(nullable = false,length = 100)
	private String specialzation;
	
	@Column(nullable = false,unique = true,length = 100)
	private String email;
	
	@ManyToMany(mappedBy = "doctors")
	private Set<Department> departments=new HashSet<Department>();
	
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments=new ArrayList<>();
	
	public List<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		return appointments;
	}


	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialzation=" + specialzation + ", email=" + email + "]";
	}

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

	public String getSpecialzation() {
		return specialzation;
	}

	public void setSpecialzation(String specialzation) {
		this.specialzation = specialzation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Doctor(Long id, String name, String specialzation, String email) {
		super();
		this.id = id;
		this.name = name;
		this.specialzation = specialzation;
		this.email = email;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
	
	

}
