package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "patient_name")
    private String patient_name;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_Date")
    private Date birth_Date;

    @Column
    private String gender;

    @Column
    private String address;

    // Null Constructor
    public Patient() {
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_Name(String patient_Name) {
        this.patient_name = patient_Name;
    }

    public Date getBirth_Date() {
        return birth_Date;
    }

    public void setBirth_Date(Date birth_Date) {
        this.birth_Date = birth_Date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
