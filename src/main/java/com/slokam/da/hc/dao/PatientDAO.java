package com.slokam.da.hc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.da.hc.DTO.DoctorDTO;
import com.slokam.da.hc.entity.Doctor;
import com.slokam.da.hc.entity.Patient;

@Repository
public interface PatientDAO extends JpaRepository<Patient, Integer>{
     // "From Visiting v join v.appointment  a  "
	 // List<Object[]>
	 
	// " select d.name,d.speci From Visiting v join v.appointment  a join a.patient p join v.doctor d"
	// " where  p.name=?1"
	
	// List<Object[]>
	
	//  select name from Patient 
	//  List<String>
	
	//  select age from Patient 
	//  List<Integer>
	//  select name,age from Patient 
	//  List<Object[]>
	
	@Query("select d from Visiting v join v.appointment a"
			+ " join a.patient p join v.doctor d "
			+ " where p.name=?1")
	public abstract List<Doctor> getDoctorNamesByPatientName(String name);
	
	
	
	
	
	
	
	
	
}
