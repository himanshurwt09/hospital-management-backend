package com.Springboot.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity 
public class Insurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true,length = 50)
	private String policyNumber;
	
	@Column(nullable = false,length = 100)
	private String provider;
	
	
	@Column(nullable = false)
	private LocalDate validUntil;
	
	@CreationTimestamp
	@Column(nullable = false,updatable = false)
	private LocalDateTime createdAt;

	//if we need name while searching insurance
	@OneToOne(mappedBy = "insurance")//name in patient side "INVERSE SIDE"
	private Patient patient;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public LocalDate getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(LocalDate validUntil) {
		this.validUntil = validUntil;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Insurance(Long id, String policyNumber, String provider, LocalDate validUntil, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.provider = provider;
		this.validUntil = validUntil;
		this.createdAt = createdAt;
	}

	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", policyNumber=" + policyNumber + ", provider=" + provider + ", validUntil="
				+ validUntil + ", createdAt=" + createdAt + "]";
	}
	
	
	
	

}
