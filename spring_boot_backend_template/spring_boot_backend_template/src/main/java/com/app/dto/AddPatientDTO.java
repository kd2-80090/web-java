package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AddPatientDTO {

	@NotBlank(message = "Patient name must be supplied!!!")
	private String name;

	private String bloodGroup;

	@NotBlank(message = "Patient email required!!!!")
	@Email(message = "Invalid email format!!")
	private String email;

	@Column(length = 10)
	private String mobile;

}
