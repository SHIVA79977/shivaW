package com.slokam.da.hc.service;

import java.util.List;
import java.util.Optional;

import com.slokam.da.hc.DTO.DoctorDTO;
import com.slokam.da.hc.entity.Doctor;
import com.slokam.da.hc.entity.Patient;
import com.slokam.da.hc.exception.PatientException;

public interface IPatientService {

	 public List<Patient> getAllPatients(String sortBy) throws PatientException;
	 public void savePatient(Patient patient) throws PatientException;
	 public Patient getPatientById(Integer id) throws PatientException;
	 public abstract List<DoctorDTO> getDoctorNamesByPatientName(String name)throws PatientException;
}
