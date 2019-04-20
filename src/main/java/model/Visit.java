package model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "visit_content")
    private String visit_content;

    @ManyToOne
    @JsonIgnore
    private Patient patient;

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

    public String getVisit_content() {
        return visit_content;
    }

    public void setVisit_content(String visit_content) {
        this.visit_content = visit_content;
    }
}
