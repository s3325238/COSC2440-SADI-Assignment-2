package dao;

import model.Patient;

import java.util.*;

public interface PatientDao {

    public List<Patient> getAllPatients();

    public void saveOrUpdatePatient(Patient patient);

    public void deletePatient(int id);

    public Patient findPatientById(int id);

    public List<Patient> findPatientByName(String patient_name);
}
