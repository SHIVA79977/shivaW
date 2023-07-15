package com.slokam.da.hc.MapperDTO;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;       
import org.mapstruct.Mappings;

import com.slokam.da.hc.DTO.DoctorDTO;
import com.slokam.da.hc.DTO.PatientDTO;
import com.slokam.da.hc.entity.Doctor;
import com.slokam.da.hc.entity.Patient;

@Mapper
public interface PatientMapper {
	
	               
	/*
	 * @Mappings({ @Mapping(source = "id", target = "did"), @Mapping(source =
	 * "name", target = "dname"),
	 * 
	 * @Mapping(source = "dob", target = "ddob"), @Mapping(source = "phone", target
	 * = "dphone"),
	 * 
	 * @Mapping(source = "disease.id", target = "mid"), @Mapping(source =
	 * "disease.name", target = "mname"),
	 * 
	 * @Mapping(source = "disease.diseaseCode", target = "mdiseaseCode"), }) public
	 * abstract List<PatientDTO> getDoctorNamesByPatientName(List<Patient> list);
	 * 
	 * @Mappings({ @Mapping(source = "id", target = "did"), @Mapping(source =
	 * "name", target = "dname"),
	 * 
	 * @Mapping(source = "dob", target = "ddob"), @Mapping(source = "phone", target
	 * = "dphone"),
	 * 
	 * @Mapping(source = "disease.id", target = "mid"), @Mapping(source =
	 * "disease.name", target = "mname"),
	 * 
	 * @Mapping(source = "disease.diseaseCode", target = "mdiseaseCode"), }) public
	 * abstract PatientDTO getDoctorNameByPatientName(Patient doctor);
	 */
	List<Doctor> doctors = new ArrayList<>();

}
