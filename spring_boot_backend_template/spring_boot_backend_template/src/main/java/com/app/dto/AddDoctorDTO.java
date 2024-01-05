package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddDoctorDTO {
	
	   @NotBlank(message = "Doctor name must be supplied!!!")
	   private String name;
		
	   @NotBlank(message ="Doctor specialization required!!!!")
	   private String special;
	  
	   @NotBlank(message ="Doctor email required!!!!")
	   @Email(message = "Invalid email format!!")
	   private String email;
	   
	   @NotBlank(message ="Hospital name required!!!!")
	   private String hospital;
	   
	   @NotBlank(message ="Hospital address required!!!!")
	   private String address;

	
}
