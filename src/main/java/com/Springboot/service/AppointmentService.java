package com.Springboot.service;

import org.springframework.stereotype.Service;

import com.Springboot.entity.Appointment;
import com.Springboot.entity.Doctor;
import com.Springboot.entity.Patient;
import com.Springboot.repository.AppointmentRepository;
import com.Springboot.repository.DoctorRepository;
import com.Springboot.repository.HospitalRepository;

import jakarta.transaction.Transactional;



@Service
public class AppointmentService {
	
	private final AppointmentRepository apointmentRepository;
	private final DoctorRepository doctorRepository;
	private final HospitalRepository patientRepository;
	
	public AppointmentService(AppointmentRepository apointmentRepository, DoctorRepository doctorRepository,
			HospitalRepository patientRepository) {
		super();
		this.apointmentRepository = apointmentRepository;
		this.doctorRepository = doctorRepository;
		this.patientRepository = patientRepository;
	}
	
	@Transactional
	public Appointment createNewAppointment(Appointment apointment, Long doctorId, Long patientId) {
		Patient patient=patientRepository.findById(patientId).orElseThrow();
		Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
		
		if(apointment.getId()!=null) throw new IllegalArgumentException("appointment shoul have to be null");
		
		apointment.setDoctor(doctor);
		apointment.setPatient(patient);
		
		//bidirection mapping
		patient.getAppointments().add(apointment);
		
		
		return apointmentRepository.save(apointment);
	}
	
	
	//if the doctor is not in the hospital we have to reassign the appointment to new doctor
	
	@Transactional
	public Appointment reassignAppointmentToAnotherDoctor(Long appointmentId,Long doctorId) {
		
		Appointment appointment=apointmentRepository.findById(appointmentId).orElseThrow();
		Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
		
		appointment.setDoctor(doctor);//this will automatocally call the update because its dirty now
		
		doctor.getAppointments().add(appointment);
		
		return appointment;
	}
	
	
	

}
