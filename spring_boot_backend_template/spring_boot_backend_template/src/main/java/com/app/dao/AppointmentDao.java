package com.app.dao;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Long> {

	Appointment findByAppointDateTimeAndDoctorId(LocalDateTime appointDateTime, Long doctorId);

	Appointment findByAppointDateTimeAndPatientId(LocalDateTime appointDateTime, Long patientId);

}
