package com.slokam.da.hc.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

	@Id
	@GeneratedValue
	private Integer did;
	private String dname;
	private String dspeci;
	
	
	
	
	
	
}
