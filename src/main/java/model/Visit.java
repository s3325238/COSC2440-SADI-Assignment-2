package model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "visit_reason")
    private String visit_reason;

    @Column(name = "main_diagnose")
    private String main_diagnose;

    @Column(name = "optional_diagnose")
    private String optional_diagnose;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Patient patient;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Prescription> prescriptionList;

    // One visit can have many drug
//    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //bydefault it is not loaded
//    private Drug drug;

     // icdenglish
//    @OneToMany
//    private Icdenglish icdenglish;

    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getVisit_reason() {
        return visit_reason;
    }

    public void setVisit_reason(String visit_reason) {
        this.visit_reason = visit_reason;
    }

    public String getMain_diagnose() {
        return main_diagnose;
    }

    public void setMain_diagnose(String main_diagnose) {
        this.main_diagnose = main_diagnose;
    }

    public String getOptional_diagnose() {
        return optional_diagnose;
    }

    public void setOptional_diagnose(String optional_diagnose) {
        this.optional_diagnose = optional_diagnose;
    }

    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }
}
