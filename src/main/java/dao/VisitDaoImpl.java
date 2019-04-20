package dao;

import model.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

//        return visits;
    }

    @Override
    public void saveOrUpdateVisit(Visit visit) {
        getSession().saveOrUpdate(visit);
    }

//    @Override
//    public void deleteVisit(int it) {
//
//    }

    @Override
    public Visit findVisitById(int id) {
        return null;
    }

    @Override
    public List<Visit> findVisitByPatientId(int id) {
        return null;
    }
}
