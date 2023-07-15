package com.slokam.da.hc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.da.hc.dao.DiseaseDAO;
import com.slokam.da.hc.entity.Disease;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.DiseaseService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DiseaseServiceImpl implements DiseaseService{
	
	@Autowired
	private DiseaseDAO diseaseDAO;
	
	
	@Override
	public void addDisease(Disease disease) throws PatientException {
		log.debug("Entered into addDisease");
		try {
			if(disease!=null) {
				log.debug("Disease Details::"+disease);
				Disease existingDisease = diseaseDAO.findByName(disease.getName());
				log.debug("Existing Disease Details with provided name::"+disease);
				if(existingDisease !=null){
					log.debug("Disease name existed allready::");
					throw new PatientException("Disease Name allready existed.");
				}
				else{
					log.debug("Saving desease details");
				    diseaseDAO.save(disease);
				}
			}
		} catch (PatientException e) {
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PatientException("DB problem", e);
		}
		log.debug("Exit from addDisease");
	}
	
}
