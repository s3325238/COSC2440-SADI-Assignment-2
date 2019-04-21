package dao;

import model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Patient> getAllPatients() {
        //Get Criteria Builder
        CriteriaBuilder builder = getSession().getCriteriaBuilder();

        //Create Criteria
        CriteriaQuery<Patient> criteria = builder.createQuery(Patient.class);
        Root<Patient> patientRoot = criteria.from(Patient.class);
        criteria.select(patientRoot);
        criteria.orderBy(builder.asc(patientRoot.get("id")));

        //Use criteria to query with session to fetch all patients
        return getSession().createQuery(criteria).getResultList();
    }

    @Override
    public void saveOrUpdatePatient(Patient patient) {
        getSession().saveOrUpdate(patient);
    }

    @Override
    public void updatePatient(Patient patient){
        getSession().update(patient);
    }

    @Override
    public void deletePatient(int id) {

        Patient patient = getSession().get(Patient.class, id);

        getSession().delete(patient);
    }

    @Override
    public Patient findPatientById(int id) {
        return getSession().get(Patient.class, id);
    }

    @Override
    public List<Patient> findPatientByName(String patient_name) {
        Query query = getSession().createQuery("from Patient p where p.patient_name like :patient_name");

        query.setParameter("patient_name", "%" + patient_name + "%");

        return query.list();
    }
}
