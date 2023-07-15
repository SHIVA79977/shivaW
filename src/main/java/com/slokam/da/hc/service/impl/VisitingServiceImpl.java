package com.slokam.da.hc.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.da.hc.dao.VisitingDAO;
import com.slokam.da.hc.entity.Visiting;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.IVisitingService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VisitingServiceImpl implements IVisitingService{

	
	@Autowired
	private VisitingDAO visitingDao;
	
	@Override
	public void visit(Visiting visiting) throws PatientException {
		log.debug("Entered into visit method.");
		try {
			if(visiting!=null){
				log.debug("visiting details::"+visiting);
				visiting.setTime(new Date());
			  visitingDao.save(visiting);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PatientException("DB error", e);
		}
		log.debug("Exit from visit method.");
	}
	
}
