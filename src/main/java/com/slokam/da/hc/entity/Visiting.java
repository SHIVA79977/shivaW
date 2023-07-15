package com.slokam.da.hc.entity;

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
public class Visiting {

	
	@Override
	public String toString() {
		return "Visiting [id=" + id + ", time=" + time + ", doctor=" + doctor + ", appointment=" + appointment + "]";
	}
	@Id
	@GeneratedValue
	private Integer id;
	private Date time;
	@OneToOne
	@JoinColumn(name="did")
	private Doctor doctor;
	@OneToOne
	@JoinColumn(name="fkaid")
	private Appointment appointment;
	
	
	
	
}
