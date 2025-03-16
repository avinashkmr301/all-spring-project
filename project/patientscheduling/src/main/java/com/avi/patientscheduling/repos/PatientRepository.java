package com.avi.patientscheduling.repos;

import com.avi.patientscheduling.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
