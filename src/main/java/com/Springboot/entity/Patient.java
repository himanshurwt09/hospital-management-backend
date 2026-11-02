package com.Springboot.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.Springboot.entity.Type.bloodgroupType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.ToString;

@Entity
@Table(
		//name="patient_tbl", //change the table name from patient to patient_tbl,
		uniqueConstraints = {
		      	@UniqueConstraint(name="unique_patient_email",columnNames = {"email"}), //this is same as @Column(unique = true)
				@UniqueConstraint(name="unique_patient_name_birthdate",columnNames = {"name","birthDate"})
				
		},
		indexes = {
				@Index(name="patient_name",columnList = "name")
		}
		
		
		)
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,length = 40)
	private String name;
	
	
	private LocalDate birthDate;
	
	@Column(unique = true,nullable = true)
	private String email;
	
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdaAt;
	
	@Enumerated(EnumType.STRING)
	private bloodgroupType bloodgroupType;
	
	@OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.ALL},orphanRemoval = true)
	@JoinColumn(name="patient_insurance_id")//owning side
	private Insurance insurance;
	
	@OneToMany(mappedBy = "patient",cascade = CascadeType.REMOVE,orphanRemoval = true) //inverse side for this many mapping
	@ToString.Exclude
	private List<Appointment> appointments=new ArrayList<>();

	

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", email=" + email
				+ ", createdaAt=" + createdaAt + ", bloodgroupType=" + bloodgroupType + "]";
	}

	public bloodgroupType getBloodgroupType() {
		return bloodgroupType;
	}

	public void setBloodgroupType(bloodgroupType bloodgroupType) {
		this.bloodgroupType = bloodgroupType;
	}

	public LocalDateTime getCreatedaAt() {
		return createdaAt;
	}

	public void setCreatedaAt(LocalDateTime createdaAt) {
		this.createdaAt = createdaAt;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	


}
