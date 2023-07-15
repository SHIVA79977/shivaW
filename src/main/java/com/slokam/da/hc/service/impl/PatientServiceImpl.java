package com.slokam.da.hc.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.da.hc.DTO.DoctorDTO;
import com.slokam.da.hc.MapperDTO.DoctorMapper;
import com.slokam.da.hc.MapperDTO.PatientMapper;
import com.slokam.da.hc.comp.PatientComparator;
import com.slokam.da.hc.comp.PatientIdComparator;
import com.slokam.da.hc.dao.PatientDAO;
import com.slokam.da.hc.entity.Doctor;
import com.slokam.da.hc.entity.Patient;
import com.slokam.da.hc.exception.PatientException;
import com.slokam.da.hc.service.IPatientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientServiceImpl implements IPatientService{
	
	private PatientMapper mapper = Mappers.getMapper(PatientMapper.class);
	@Autowired
	private PatientDAO PatientDAO;

	@Override
	public void savePatient(Patient patient) throws PatientException {

		log.debug("savePatient start");
		try {
			PatientDAO.save(patient);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PatientException("DB Problem", e);
		}

		log.debug("savePatient end");
	}

	@Override
	public Patient getPatientById(Integer id) throws PatientException {
		log.debug("getPatientById start");
		Patient p = null;
		try {
			Optional<Patient> optional = PatientDAO.findById(id);
			if (optional.isPresent()) {
				p = optional.get();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new PatientException("DB Problem", e);
		}
		log.debug("getPatientById end");
		return p;
	}

	@Override
	public List<DoctorDTO> getDoctorNamesByPatientName(String name) throws PatientException {
		log.info("getDoctorNamesByPatientName start");
		List<DoctorDTO> dtos = null;

		try {
			List<Doctor> doctorNames = PatientDAO.getDoctorNamesByPatientName(name);

			DoctorMapper mapper = Mappers.getMapper(DoctorMapper.class);
			dtos = mapper.getDoctorNamesByPatientName(doctorNames);
			log.info("list of dto----------" + dtos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PatientException("Db issue", e);
		}
		log.info("getDoctorNamesByPatientName end");
		return dtos;
	}

	@Override
	public List<Patient> getAllPatients(String sortBy) throws PatientException {
		log.debug("getAllPatients start");
		List<Patient> patientList = PatientDAO.findAll();

		Comparator<Patient> comparator = PatientComparator.getPatientComparator(sortBy);
		Collections.sort(patientList, comparator);
		log.debug("getAllPatients end");
		return patientList;
	}

	public Patient getMaxAgePatient() {
		Patient p = null;
		log.debug("getMaxAgePatient start");
		List<Patient> patientList = PatientDAO.findAll();
		for (Patient patient : patientList) {
			if (p == null) {
				p = patient;
			} else {
				Date dob1 = patient.getDob();
				Date dob2 = p.getDob();
				if (dob1.after(dob2)) {
					p = patient;
				}
			}

		}
		log.debug("getMaxAgePatient end");
		return p;
	}
}
