package com.avi.patientscheduling.repos;

import com.avi.patientscheduling.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
