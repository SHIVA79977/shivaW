package com.slokam.da.hc.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.da.hc.DTO.DoctorDTO;
import com.slokam.da.hc.entity.Doctor;
import com.slokam.da.hc.entity.Patient;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.IPatientService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("patient")
@Slf4j
public class PatientController {
	
	@Autowired
	private IPatientService patientService;
	@PostMapping
	public void savePatient(@RequestBody Patient patient) throws PatientException{
		log.debug("Entered into savePatient");
		patientService.savePatient(patient);
		log.debug("Exit from  savePatient");
	}
	
	 @GetMapping("/doctors/{pname}")
	 public ResponseEntity<List<DoctorDTO>> getDoctorNamesByPatientName(@PathVariable(name="pname") String name) throws PatientException{
		 log.info("Entered into getDoctorNamesByPatientName");
		 ResponseEntity<List<DoctorDTO>> re;
		 String s="not found";
		 List<DoctorDTO> doctorNames = patientService.getDoctorNamesByPatientName(name); 
			if(doctorNames!=null) {
			 
					re=new ResponseEntity<List<DoctorDTO>>(doctorNames,HttpStatus.OK );
			}else {
				re=new ResponseEntity(s,HttpStatus.NOT_FOUND );
			}
			log.info("Exit from  getDoctorNamesByPatientName");
			return re;
	 }
	 @GetMapping("/all/{sortBy}")
	 public ResponseEntity<List<Patient>> getAllPatients(@PathVariable String sortBy) throws PatientException {
		 log.debug("Entered into List<Patient>");
		  List<Patient>  list = patientService.getAllPatients(sortBy);
		  ResponseEntity<List<Patient>> re =
					new ResponseEntity<List<Patient>>(list,HttpStatus.OK );
		  log.debug("Exit from  List<Patient>");
			return re;
	 }
}
