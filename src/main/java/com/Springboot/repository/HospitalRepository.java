package com.Springboot.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Springboot.Dto.BloodGroupCountDto;
import com.Springboot.entity.Patient;
import com.Springboot.entity.Type.bloodgroupType;

import jakarta.transaction.Transactional;

public interface HospitalRepository extends JpaRepository<Patient, Long>{

	

	Patient findByName(String name);


	List<Patient>  findByBirthDateOrEmail(LocalDate birthdate,String email);
	
	Patient findByBirthDate(LocalDate birthdate);
	
	List<Patient> findByBirthDateBetween(LocalDate startdate,LocalDate enddate);
	
	List<Patient> findByNameContaining(String query);
	
	
	
	//JPQL query
	
	@Query("SELECT p FROM Patient p where p.bloodgroupType=?1")//no=?1 because sql attack
	List<Patient> findbybloodgroup(@Param("bloodgroupType") bloodgroupType bloodgroup);
	
	@Query("SELECT d FROM Patient d where d.birthDate > :birthDate")
	List<Patient> finebybornafterdate(@Param("birthDate")LocalDate birthDate);
	
	@Query("select p.bloodgroupType,count(p) from Patient p group by p.bloodgroupType")
	List<Object[]> counteachbloodgrouptype();
	
	
	//update JPQL query
	
	@Transactional
	@Modifying
	@Query("UPDATE Patient p SET p.name= :name where p.id= :id")
	int updatenameWithId(@Param("name")String name,@Param("id") long id);
	
	
	
	//native SQL Query
	
	@Query(value="select * from patient" ,nativeQuery = true)
	Page<Patient> findallpatients(Pageable pageble);
	
	
	//Projection and pagination
	
	@Query("select new com.Springboot.Dto.BloodGroupCountDto"
			+ "( p.bloodgroupType,count(p)) from Patient p group by p.bloodgroupType")
	List<BloodGroupCountDto> counteachbloodgroup(); 

}


