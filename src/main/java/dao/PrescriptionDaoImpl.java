package dao;

import model.Prescription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PrescriptionDaoImpl implements PrescriptionDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        // Create Criteria Builder
        CriteriaBuilder builder = getSession().getCriteriaBuilder();

        //Create Criteria
        CriteriaQuery<Prescription> criteria = builder.createQuery(Prescription.class);
        Root<Prescription> prescriptionRoot = criteria.from(Prescription.class);
        criteria.select(prescriptionRoot);
        criteria.orderBy(builder.asc(prescriptionRoot.get("id")));

        //Use criteria to query with session to fetch all prescriptions
        return getSession().createQuery(criteria).getResultList();
    }

    @Override
    public void saveOrUpdatePrescription(Prescription prescription) {
        getSession().saveOrUpdate(prescription);
    }

    @Override
    public Prescription findPrescriptionById(int id) {
        return null;
    }

    @Override
    public List<Prescription> findPrescriptionByVisitId(int id) {
        return null;
    }
}
