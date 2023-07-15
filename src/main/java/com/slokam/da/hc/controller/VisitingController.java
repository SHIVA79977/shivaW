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

import com.slokam.da.hc.entity.Visiting;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.IVisitingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("visiting")
@Slf4j
public class VisitingController {
	
	@Autowired
	private IVisitingService visitingService;
	
	@PostMapping() 
	public ResponseEntity<String> visit(@RequestBody Visiting visiting) throws PatientException{
		log.debug("Entered into visit");
		ResponseEntity<String> re= null;
		if(visiting!=null){
			log.debug("visiting data"+visiting);
			visitingService.visit(visiting);
			re = new ResponseEntity<String>(HttpStatus.CREATED);
		}else{
			re = new ResponseEntity<String>("null visiting",HttpStatus.BAD_REQUEST);
		}
		log.debug("Exit from visit");
		return re;
	}
	
}
