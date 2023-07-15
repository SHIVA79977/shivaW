package com.slokam.da.hc.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.da.hc.dao.AppointmentDAO;
import com.slokam.da.hc.entity.Appointment;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.IAppointmentService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class AppointmentServiceImpl implements IAppointmentService{
	
	@Autowired
	private AppointmentDAO appointDao;

	@Override
	public void createAppointment(Appointment appointment) throws PatientException {
		//appointDao.save(appointment);
		
		log.info("AppointmentDAO--------------------------------------");
		
	}
	
//	@Override
//	public void createAppointment(Appointment appointment) throws PatientException {
//		log.debug("Entered into createAppointment");
//		
//		try {
//			if(appointment!=null) {
//				appoin00tment.setTaken(new Date());
//				log.debug("Appointment Details::"+appointment);
//				appointDao.save(appointment);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new PatientException("DB problem", e);
//		}
//		log.debug("Exit from createAppointment");
//	}
	
}
