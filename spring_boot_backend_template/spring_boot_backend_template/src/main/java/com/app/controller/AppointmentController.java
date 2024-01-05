package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddAppoDTO;
import com.app.dto.RespAppoDTO;
import com.app.service.AppoService;


@RestController
@RequestMapping("/appointments")
public class AppointmentController 
{
	@Autowired
	private AppoService appoService;
	
	public AppointmentController() {
		System.out.println("In AppointmentController ctor ");
	}
	
	@GetMapping
	public ResponseEntity<?>  getAllAppoints()
	{
		System.out.println("in list appointments");
		System.out.println(appoService.getAllAppoints());
		List<RespAppoDTO> appointments = appoService.getAllAppoints();
		if (appointments != null ) 
            // Return a successful response (HTTP 200 OK)
            return ResponseEntity.ok(appointments);
         else 
            // Return a custom error response with a specific status code (e.g., HTTP 404 Not Found)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
	}
	
	@PostMapping
	public ResponseEntity<?> bookAppo(@Valid @RequestBody AddAppoDTO apodto) 
	{
		System.out.println("in list appointments");
		//return appoService.bookAppo(apodto);
		//return ResponseEntity.ok(appoService.bookAppo(apodto));
		
		RespAppoDTO respDt=appoService.bookAppo(apodto);
	
		if ( respDt!= null) 
            return ResponseEntity.ok(respDt);
         else 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to book appointment try again");
        
		
		
	}

}
