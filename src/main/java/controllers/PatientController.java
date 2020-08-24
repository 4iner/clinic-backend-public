package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import models.Patient;
import models.Visit;
import models.enums.PlasticSurgeryProcedure;
import models.specs.PatientSpec;
import repositories.PatientRepository;
import repositories.VisitRepository;


@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    VisitRepository visitRepository;





    @GetMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public Iterable<Patient> getPatients(PatientSpec spec, @RequestParam(value = "procedure", required = false) String procedure) {
        List<Patient> patients = patientRepository.findAll(spec);
        if(procedure != null){
            List<Patient> patientsWithProc = new ArrayList<>();
            PlasticSurgeryProcedure proc = PlasticSurgeryProcedure.fromString(procedure);
            if(proc == null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                            "The requested procedure was not found");
            }
            List<Visit> visits = visitRepository.findByPlasticSurgeryProcedure(proc);
            
            for(Visit v : visits){
                if(patients.contains(v.getPatient())){
                    patientsWithProc.add(v.getPatient());
                }
            }

            return patientsWithProc;
        }

        return patients;
        
    }

    /**
     * Gets a patient given an id in the path
     * 
     * @param id id of patient
     * @return patient with the given ID
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Patient getPatient(@PathVariable Integer id) {
        Optional<Patient> p = patientRepository.findById(id);
        if (p.isPresent())
            return p.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested patient was not found");
    }

    /**
     * Creates a patient given the JSON representation as a request body
     * 
     * @param patient Serialized patient from JSON
     * @return patient created from the database
     */
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public Patient createPatient(@Valid @RequestBody Patient patient) {
        patient = patientRepository.save(patient);
        return patient;
    }

    /**
     * Update a patient given its representation in JSON
     * 
     * @param id id of patient being updated
     * @return
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Patient updatePatient(@RequestBody Patient patient, @PathVariable Integer id) {
        Optional<Patient> op = patientRepository.findById(id);
        if (op.isPresent()) {
            Patient p = op.get();
            p.setFirstName(patient.getFirstName());
            p.setMiddleName(patient.getMiddleName());
            p.setLastName(patient.getLastName());
            p.setEmail(patient.getEmail());
            p.setDateOfBirth(patient.getDateOfBirth());
            p.setGender(patient.getGender());
            p = patientRepository.save(p);
            return p;
        }
        return null;
    }

    /**
     * Deletes a patient given the JSON representation as a request body
     * 
     * @param id id of patient
     * @return patient if present or null otherwise
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String deletePatient(@PathVariable Integer id) {
        Optional<Patient> op = patientRepository.findById(id);
        if(op.isPresent()){
            Patient p = op.get();
            patientRepository.delete(p);
            return "Patient deleted";
        }
        

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found");
    }

    
   

}
