package com.Springboot.service;

import org.springframework.stereotype.Service;

import com.Springboot.entity.Patient;
import com.Springboot.repository.HospitalRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
	
	private final HospitalRepository hospitalRepository;

	public PatientService(HospitalRepository hospitalRepository) {
		super();
		this.hospitalRepository = hospitalRepository;
	}
	
	
	@Transactional
	public Patient getpatient(Long id) {
		
		Patient p1=hospitalRepository.findById(id).orElseThrow();

		Patient p2=hospitalRepository.findById(id).orElseThrow();
		
		System.out.println(p1==p2);
		
		p1.setName("yoyo");
		
		//hospitalRepository.save(p1);  not nessassry  because of dirty checking
		
		return p1;
		
		
		
		
	}
	

}
