package com.slokam.da.hc.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.da.hc.dao.IDoctorDAO;
import com.slokam.da.hc.dao.PatientDAO;
import com.slokam.da.hc.entity.Doctor;
import com.slokam.da.hc.entity.Patient;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.IDoctorService;
import com.slokam.da.hc.service.IPatientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DoctorServiceImpl implements IDoctorService{
   
	@Autowired
	private IDoctorDAO doctorDAO;
	@Override
 	public void save(Doctor doctor)throws PatientException {
		
		log.debug("save start");
		try{
			doctorDAO.save(doctor);
		}catch(Exception e){
			e.printStackTrace();
			throw new PatientException("DB Problem",e);
		}
		
		log.debug("save end");
	}
	  
	
	
}
