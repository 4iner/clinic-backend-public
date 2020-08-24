package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import models.enums.PlasticSurgeryProcedure;
import models.json.PlasticSurgeryProcedure.ProcedureDeserializer;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private Patient patient;
    @NotBlank
    private String medicalNote;

    private LocalDate date;



    @JsonProperty("procedure")
    @JsonDeserialize(using = ProcedureDeserializer.class)
    private PlasticSurgeryProcedure plasticSurgeryProcedure;
 
    @ElementCollection
    private List<String> photos = new ArrayList<>();





    

    public Visit() {
    }

    public Visit(String medicalNote, PlasticSurgeryProcedure procedure){
        this.medicalNote = medicalNote;
        this.plasticSurgeryProcedure = procedure;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMedicalNote() {
        return this.medicalNote;
    }

    public void setMedicalNote(String medicalNote) {
        this.medicalNote = medicalNote;
    }

    public PlasticSurgeryProcedure getPlasticSurgeryProcedure() {
        return this.plasticSurgeryProcedure;
    }

    public void setPlasticSurgeryProcedure(PlasticSurgeryProcedure plasticSurgeryProcedure) {
        this.plasticSurgeryProcedure = plasticSurgeryProcedure;
    }

    public Visit id(Integer id) {
        this.id = id;
        return this;
    }

    public Visit patient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public Visit medicalNote(String medicalNote) {
        this.medicalNote = medicalNote;
        return this;
    }

    public Visit plasticSurgeryProcedure(PlasticSurgeryProcedure plasticSurgeryProcedure) {
        this.plasticSurgeryProcedure = plasticSurgeryProcedure;
        return this;
    }

    public void addPhoto(String photo){
        this.photos.add(photo);
    }

    public void removePhoto(String photo){
        this.photos.remove(photo);
    }
    
    public List<String> getPhotos() {
        return this.photos;
    }

    public void setPhotos(List<String> Photos) {
        this.photos = Photos;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Visit)) {
            return false;
        }
        Visit visit = (Visit) o;
        return Objects.equals(medicalNote, visit.medicalNote) && Objects.equals(plasticSurgeryProcedure, visit.plasticSurgeryProcedure) && Objects.equals(visit.date, date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, medicalNote, plasticSurgeryProcedure);
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", patient='" + getPatient() + "'" +
            ", medicalNote='" + getMedicalNote() + "'" +
            ", date='" + getDate() + "'" +
            ", procedure='" + getPlasticSurgeryProcedure() + "'" +
            "}";
    }


}
