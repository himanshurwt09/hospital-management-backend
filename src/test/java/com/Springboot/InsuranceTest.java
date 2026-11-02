package com.Springboot;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Springboot.entity.Insurance;
import com.Springboot.entity.Patient;
import com.Springboot.service.InsuranceService;

@SpringBootTest
public class InsuranceTest {
	
	@Autowired
	private InsuranceService insuranceservice;
	
	@Test
	public void testInsurance() {
		Insurance insurance=new Insurance();
		insurance.setPolicyNumber("HDFC_1234");
		insurance.setProvider("HDFC");
		insurance.setValidUntil(LocalDate.of(2030, 10, 10));
		
		Patient patient= insuranceservice.assignInsuranceToPatient(insurance, 1L);
		System.out.println(patient);
		
	}
	
	@Test
	public void testDissassociationInsurance() {
		Long patientId=1L;
		
		var updatepatient=insuranceservice.disaccocaiteInsuranceFromPatient(patientId);
		System.out.println(updatepatient);
	}

}
