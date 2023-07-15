package com.slokam.da.hc.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseDTO {

	@Id
	@GeneratedValue
	private Integer mid;
	
	@Length(min=4,max=10)
	private String mname;
	@Pattern(regexp="^DD[A-Z]+$")
	private String mdiseaseCode;
	
	
	
	
	
}
