package service;

import dao.PatientDao;
import model.Patient;
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
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Autowired
    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDao.getAllPatients();
    }

    @Override
    public void saveOrUpdatePatient(Patient patient) {
        patientDao.saveOrUpdatePatient(patient);
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
        Query query = getSession().createQuery("from Patient p where p.name like :patient_name");

        query.setParameter("patient_name", "%" + patient_name + "%");

        return query.list();
    }

    //    @Autowired
//    SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public Session getCurrentSessionFactory() {
//        return sessionFactory.getCurrentSession();
//    }
//
//    // Read all
//    public List<Patient> getAllPatients() {
//        Query query = getCurrentSessionFactory().createQuery("from Patient ORDER BY id");
//        return query.list();
//    }
//
//    // Get Patient By Id
//    public Patient getPatientById(int id) {
//        Query query = getCurrentSessionFactory().createQuery("FROM Patient where id = :id");
//
//        query.setParameter("id", id);
//
//        return (Patient) query.uniqueResult();
//
//    }
//
//    // Get Patient by name
//    public List<Patient> getPatientByName(String patient_name) {
//        Query query = getCurrentSessionFactory().createQuery("from Patient p where p.patient_name like :patient_name");
//
//        query.setParameter("patient_name", "%" + patient_name + "%");
//
//        return query.list();
//    }
//
//    // Save
//    public String savePatient(Patient patient) {
//
//        getCurrentSessionFactory().save(patient);
//
//        return "New patient has been added with id: " + patient.getId();
//    }
//
//    // Update
//    public String updatePatient(Patient patient) {
//
//        getCurrentSessionFactory().update(patient);
//
//        return "Data on id: " + patient.getId() + " has been updated.";
//    }
//
//    // Delete
//    public void deletePatient(int id) {
//
//        Patient patient = getCurrentSessionFactory().get(Patient.class, id);
//
//        getCurrentSessionFactory().delete(patient);
//
//    }
}
