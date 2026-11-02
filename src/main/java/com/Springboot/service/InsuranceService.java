package com.Springboot.service;

import org.springframework.stereotype.Service;

import com.Springboot.entity.Insurance;
import com.Springboot.entity.Patient;
import com.Springboot.repository.HospitalRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class InsuranceService {
	
		private final HospitalRepository patientrepository;
	
	public InsuranceService(HospitalRepository patientrepository) {
		super();
		
		this.patientrepository = patientrepository;
	}
	
	@Transactional
	public Patient assignInsuranceToPatient(Insurance insurance,Long patientId) {
		Patient patient= patientrepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("patient not found with id"+patientId));
		
		patient.setInsurance(insurance);
		insurance.setPatient(patient);  //biderctional consistency maintainance 
		
		return patient;
		
	}

	
	@Transactional
	public Patient disaccocaiteInsuranceFromPatient(Long patientId) {
		Patient patient= patientrepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("patient not found with id"+patientId));
		
		patient.setInsurance(null);
		return patient;
		
	}
}
