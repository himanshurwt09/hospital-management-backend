package com.Springboot;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.Springboot.Dto.BloodGroupCountDto;
import com.Springboot.entity.Patient;
import com.Springboot.entity.Type.bloodgroupType;
import com.Springboot.repository.HospitalRepository;
import com.Springboot.service.PatientService;

@SpringBootTest
public class PatientTest {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private PatientService paitentService;
	
//	@Test
//	public void TestPaitentRepository() {
//		List<Patient> paitientList=hospitalRepository.findAll();
//		System.out.println(paitientList);
//		
//	}
	
	@Test
	public void testtransictionmethod() {
		Patient paitent=paitentService.getpatient(1L);
		System.out.println(paitent);
		
		
    	Patient patient=hospitalRepository.findByName("Diya Patel");
	    System.out.println(patient);
 
		Patient birthday=hospitalRepository.findByBirthDate(LocalDate.of(1990, 5, 10));
		System.out.println(birthday);
		
		
		List<Patient> listofnames=hospitalRepository.findByBirthDateOrEmail(LocalDate.of(1992, 12, 1), "neha.iyer@example.com");
		System.out.println(listofnames);
		
		List<Patient> query=hospitalRepository.findByNameContaining("Di");
		System.out.println(query);
		
		List<Patient> JPQLquery=hospitalRepository.findbybloodgroup(bloodgroupType.O_POSITIVE);
		System.out.println(JPQLquery);
		
		
		List<Patient> findbornafter=hospitalRepository.finebybornafterdate(LocalDate.of(1988, 2, 14));
		System.out.println(findbornafter);
		
		List<Object[]> bloodgroupList=hospitalRepository.counteachbloodgrouptype();
		for(Object[] objects:bloodgroupList) {
			System.out.println(objects[0]+"  "+objects[1]);
		}
		
		int updatename=hospitalRepository.updatenameWithId("Arav Sharmala", 1L);
		System.out.println(updatename);
		
		
		//SQL native query
		Page<Patient> findall=hospitalRepository.findallpatients(PageRequest.of(0, 2,Sort.by("name")));
		for (Patient patients : findall.getContent()) {
			System.out.println(patients);
			
		}
		
		//projection and pagination
		List<BloodGroupCountDto> bloodgroupcount=hospitalRepository.counteachbloodgroup();
		for(BloodGroupCountDto bloodGroupCountDto: bloodgroupcount) {
			System.out.println(bloodGroupCountDto);
		}
	}
}


