package dao;

import model.Patient;
import model.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class VisitDaoImpl implements VisitDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Visit> getAllVisits() {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();

        //Create Criteria
        CriteriaQuery<Visit> criteria = builder.createQuery(Visit.class);
        Root<Visit> visitRoot = criteria.from(Visit.class);
        criteria.select(visitRoot);
        criteria.orderBy(builder.asc(visitRoot.get("id")));

        //Use criteria to query with session to fetch all contacts
        return getSession().createQuery(criteria).getResultList();

    }

    @Override
    public void saveOrUpdateVisit(Visit visit) {
        getSession().saveOrUpdate(visit);
    }

    @Override
    public Visit findVisitById(int id) {
        return getSession().get(Visit.class, id);
    }

    @Override
    public List<Visit> findVisitByPatientId(int id) {

        Query query = getSession().createQuery("from Visit as v where v.patient.id = :id");

        // Set parameter with name in the query, and id from param
        query.setParameter("id", id);

        return query.list();
    }
}
