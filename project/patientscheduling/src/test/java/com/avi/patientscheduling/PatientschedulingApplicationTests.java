package com.avi.patientscheduling;

import com.avi.patientscheduling.entity.Appointment;
import com.avi.patientscheduling.entity.Doctor;
import com.avi.patientscheduling.entity.Insurance;
import com.avi.patientscheduling.entity.Patient;
import com.avi.patientscheduling.repos.AppointmentRepository;
import com.avi.patientscheduling.repos.DoctorRepository;
import com.avi.patientscheduling.repos.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PatientschedulingApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	AppointmentRepository appointmentRepository;
	@Test
	void testCreateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Dilip");
		doctor.setLastName("Thakur");
		doctor.setSpeciality("All");

		doctorRepository.save(doctor);
	}
	@Test
	void testCreatePatient(){
		Patient patient = new Patient();
		patient.setFirstName("Rajeev");
		patient.setLastName("Ghorpare");
		patient.setPhone("12345");

		Insurance insurance = new Insurance();
		insurance.setProviderName("Blue Cross");
		insurance.setCopay(20d);
		patient.setInsurance(insurance);

		Doctor doctor = doctorRepository.findById(1).get();
		List<Doctor> doctors = Arrays.asList(doctor);
		patient.setDoctors(doctors);

		patientRepository.save(patient);
	}
	@Test
	void testCreateAppointment(){

		Appointment appointment = new Appointment();

		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime);

		appointment.setReason("I have a problem");
		appointment.setStarted(true);
		appointment.setPatient(patientRepository.findById(1).get());
		appointment.setDoctor(doctorRepository.findById(1).get());

		appointmentRepository.save(appointment);
	}

}
