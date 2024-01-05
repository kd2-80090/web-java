package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AppointmentDao;
import com.app.dao.DoctorDao;
import com.app.dao.PatientDao;
import com.app.dto.AddAppoDTO;
import com.app.dto.RespAppoDTO;
import com.app.entities.Appointment;
import com.app.entities.Doctor;
import com.app.entities.Patient;

@Service
@Transactional
public class AppoServiceImpl implements AppoService {

	
	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private AppointmentDao aptDao;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public List<RespAppoDTO> getAllAppoints() {
		// TODO Auto-generated method stub
		
		return
		aptDao.findAll()
		.stream()
		.map(appoint ->mapper.map(appoint, RespAppoDTO.class))
		.collect(Collectors.toList());
	}

	@Override
	public RespAppoDTO bookAppo(AddAppoDTO apodto) 
	{
		Doctor doctor=doctorDao.findById(apodto.getDoctorId()).orElseThrow(()->new ResourceNotFoundException("Invalid doctor id"));
		Patient patient= patientDao.findById(apodto.getPatientId()).orElseThrow(()->new ResourceNotFoundException("Invalid patient id"));
		
		if(aptDao.findByAppointDateTimeAndDoctorId(apodto.getAppointDateTime(),apodto.getDoctorId())== null 
			&& aptDao.findByAppointDateTimeAndPatientId(apodto.getAppointDateTime(),apodto.getPatientId())==null) 
		{
		Appointment appot=mapper.map(apodto, Appointment.class);
		appot.setDoctor(doctor);
		appot.setPatient(patient);
		
		Appointment persistappot=aptDao.save(appot);
		RespAppoDTO respDto=mapper.map(persistappot, RespAppoDTO.class);
		if(respDto != null) {
		    respDto.setMessage("Appointment Booked Successfully");
					 return respDto;
		   }
	   }
		return null;

	}

	

}
