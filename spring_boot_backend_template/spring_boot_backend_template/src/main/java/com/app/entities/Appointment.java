package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="appointments")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Appointment extends BaseEntity{

	// Appointment *--->1 Doctor
		@ManyToOne
		@JoinColumn(name = "doctor_id", nullable = false)
   private Doctor doctor;
   
	// Appointment *--->1 Patient
		@ManyToOne
		@JoinColumn(name = "patient_id", nullable = false)
   private Patient patient;
		  
	@Column(length = 20)
   private LocalDateTime appointDateTime;
	
   @Column(length = 150)
	private String description;

}
