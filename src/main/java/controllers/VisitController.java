package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import models.Patient;
import models.Visit;
import models.json.PhotosPayload;
import repositories.PatientRepository;
import repositories.VisitRepository;



@RestController
@RequestMapping("/api/patients/{id}/visits")
public class VisitController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    VisitRepository visitRepository;




    @PostMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public Visit addVisit(@Valid @RequestBody Visit visit, @PathVariable Integer id) {
        Optional<Patient> op = patientRepository.findById(id);
        if (op.isPresent()) {
            Patient pd = op.get();
            visit.setPatient(pd);
            visit = visitRepository.save(visit);
            return visit;
        }
        return null;
    }

    @PutMapping("/{visitId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Visit updateVisit(@RequestBody Visit visit, @PathVariable Integer id, @PathVariable Integer visitId) {
        Optional<Visit> ov = visitRepository.findById(visitId);
        if (ov.isPresent()) {
            Visit v = ov.get();
            v.setMedicalNote(visit.getMedicalNote());
            v.setDate(visit.getDate());
            v.setPlasticSurgeryProcedure(visit.getPlasticSurgeryProcedure());
            v = visitRepository.save(v);
            return v;
        }
        return null;
    }

    @GetMapping("/{visitId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Visit getVisit(@PathVariable Integer id, @PathVariable Integer visitId) {
        Optional<Visit> ov = visitRepository.findById(visitId);
        if (ov.isPresent()) {
            Visit v = ov.get();
            return v;
        }
        return null;
    }

    @DeleteMapping("/{visitId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Patient deleteVisit(@PathVariable Integer id, @PathVariable Integer visitId) {
        Optional<Patient> op = patientRepository.findById(id);
        if (op.isPresent()) {
            Patient p = op.get();
            Optional<Visit> visit = visitRepository.findById(visitId);
            if (visit.isPresent()) {
                p.removeVisit(visit.get());
                p = patientRepository.save(p);
                return p;
            }
            ;
        }
        return null;
    }

  

}