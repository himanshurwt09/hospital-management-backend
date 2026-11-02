package com.Springboot;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Springboot.entity.Appointment;
import com.Springboot.service.AppointmentService;

@SpringBootTest
public class AppointmentTest {
	
	@Autowired
	private AppointmentService appointmentService;
	
	
	@Test
	public void apointmenttests() {
		Appointment apointment=new Appointment();
		apointment.setAppointmentTime(LocalDateTime.of(2026, 11, 1, 10, 0 ,0));
		apointment.setReason("infested with zombies");
		
		
		var newAppointment =appointmentService.createNewAppointment(apointment, 1L, 2L);
		System.out.println(newAppointment);
		
		
		
		
	}
	
	@Test
	public void assignNewDoctor() {
		Long appointmentId=1L;
		Long newDoctor=3L;
		var updateappointment=appointmentService.reassignAppointmentToAnotherDoctor(appointmentId, newDoctor);
		System.out.println(updateappointment);
	}

}
