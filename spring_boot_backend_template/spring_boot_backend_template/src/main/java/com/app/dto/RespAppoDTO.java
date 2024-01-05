package com.app.dto;

import java.time.LocalDateTime;


import com.app.entities.Doctor;
import com.app.entities.Patient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RespAppoDTO {

	@JsonProperty(value="appoint_id",access = Access.READ_ONLY)
	private Long id;
	
	private Doctor doctor;

	private Patient patient;
		
	private LocalDateTime appointDateTime;
	
    private String message;
}
