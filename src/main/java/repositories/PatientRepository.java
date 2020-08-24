package repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import models.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer>, JpaSpecificationExecutor<Patient> {

}