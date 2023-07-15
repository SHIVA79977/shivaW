package com.slokam.da.hc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.da.hc.entity.Appointment;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.IAppointmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("appointment")
@Slf4j
public class AppointmentController {

	@Autowired
	private IAppointmentService appointmentService;
	
	@PostMapping("saveappointment") 
	public ResponseEntity<String> createAppointment
	  (@RequestBody Appointment appointment) throws PatientException{
		log.debug("Entered into createAppointment"+appointment);
		 ResponseEntity<String> re =null ;
		if(appointment!=null){
			log.debug("Appointment::"+appointment);
			appointmentService.createAppointment(appointment);
		    re = new ResponseEntity<String>("Successfully inserted",HttpStatus.OK);
		}else{
			re = new ResponseEntity<String>("Data is not present",HttpStatus.BAD_REQUEST);
		}
			
		log.info("Exit from createAppointment");
		return re;
	}
}
