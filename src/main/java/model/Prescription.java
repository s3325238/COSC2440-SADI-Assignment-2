package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "main_content")
    private String main_content;

    @Column(name = "optional_content")
    private String optional_content;

    @ManyToOne
    @JsonIgnore
    private Visit visit;

//    @ManyToOne
//    @JsonIgnore
//    private Patient patient;


    // Getter & Setter


//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain_content() {
        return main_content;
    }

    public void setMain_content(String main_content) {
        this.main_content = main_content;
    }

    public String getOptional_content() {
        return optional_content;
    }

    public void setOptional_content(String optional_content) {
        this.optional_content = optional_content;
    }
}
