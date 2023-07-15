package com.slokam.da.hc.DTO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="visiting")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitingDTO {

	
	
	@Id
	@GeneratedValue
	private Integer id;
	private Date time;
	
	
	
	
	
}
