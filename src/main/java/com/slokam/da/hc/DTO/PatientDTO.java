package com.slokam.da.hc.DTO;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.slokam.da.hc.entity.Disease;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
	
	
	@Id
	@GeneratedValue
	private Integer did;
	private String dname;
	private Date ddob;
	@Column(name="phnnum")
	private Long dphone;
	private List<Disease> ddisease;
    
}
