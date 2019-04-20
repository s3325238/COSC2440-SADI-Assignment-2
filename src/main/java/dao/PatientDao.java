package dao;

import model.Patient;

import java.util.*;

public interface PatientDao {

    public List<Patient> getAllPatients();

    public void saveOrUpdatePatient(Patient patient);

    public void updatePatient(Patient patient); // New implement function

    public void deletePatient(int id);

    public Patient findPatientById(int id);

    public List<Patient> findPatientByName(String patient_name);
}
