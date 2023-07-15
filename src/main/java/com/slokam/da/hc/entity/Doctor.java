package com.slokam.da.hc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String speci;
	
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", speci=" + speci + "]";
	}
	
	
	
}
