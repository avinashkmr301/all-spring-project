package com.avi.patientscheduling.repos;

import com.avi.patientscheduling.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
