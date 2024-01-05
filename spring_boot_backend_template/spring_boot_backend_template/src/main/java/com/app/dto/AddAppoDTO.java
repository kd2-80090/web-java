package com.app.dto;


import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddAppoDTO {

	@NotNull(message ="Doctor Id required!!!!")//DOCTOR ID
	private Long doctorId;

	@NotNull(message ="Patient Id required!!!!")//Patient ID
	private Long patientId;
		
	@NotNull(message =" Appointment Date AND Time required!!!!")
	private LocalDateTime appointDateTime;
	
	@NotBlank(message ="Description required!!!!")
    private String description;
}
