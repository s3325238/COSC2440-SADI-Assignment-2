package service;

import model.Patient;

import java.util.List;

public interface PatientService {

    public List<Patient> getAllPatients();

    public int saveOrUpdatePatient(Patient patient);

    public String updatePatient(Patient patient); // New implement function

    public void deletePatient(int id);

    public Patient findPatientById(int id);

    public List<Patient> findPatientByName(String patient_name);

}
