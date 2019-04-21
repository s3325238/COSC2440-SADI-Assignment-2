package service;

import dao.PatientDao;
import model.Patient;
import model.Prescription;
import model.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    PatientDao patientDao;

    @Autowired
    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDao.getAllPatients();
    }

    @Override
    public int saveOrUpdatePatient(Patient patient) {

        if (patient.getVisitList() != null){
            for (Visit visit : patient.getVisitList()) {
                visit.setPatient(patient);
                for (Prescription prescription: visit.getPrescriptionList()){
                    prescription.setVisit(visit);
                }
            }
        }

        patientDao.saveOrUpdatePatient(patient);

        return patient.getId();
    }

    @Override
    public String updatePatient(Patient patient){

        patientDao.updatePatient(patient);

        return "Data has been updated on id: "+patient.getId();
    }

    @Override
    public void deletePatient(int id) {
        patientDao.deletePatient(id);
    }

    @Override
    public Patient findPatientById(int id) {
        return patientDao.findPatientById(id);
    }

    @Override
    public List<Patient> findPatientByName(String patient_name) {

        return patientDao.findPatientByName(patient_name);

    }
}
