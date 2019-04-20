package dao;

import model.Drug;
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
public class DrugDaoImpl implements DrugDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Drug> getAllDrugs() {

        //Get Criteria Builder
        CriteriaBuilder builder = getSession().getCriteriaBuilder();

        //Create Criteria
        CriteriaQuery<Drug> criteria = builder.createQuery(Drug.class);
        Root<Drug> drugRoot = criteria.from(Drug.class);
        criteria.select(drugRoot);
        criteria.orderBy(builder.asc(drugRoot.get("id")));

        //Use criteria to query with session to fetch all contacts
        return getSession().createQuery(criteria).getResultList();

    }

    @Override
    public void saveOrUpdateDrug(Drug drug) {
        getSession().saveOrUpdate(drug);
    }

    @Override
    public void deleteDrug(int id) {

        Drug drug = getSession().get(Drug.class, id);

        getSession().delete(drug);
    }

    @Override
    public Drug findDrugById(int id) {

        return getSession().get(Drug.class, id);

    }

    @Override
    public List<Drug> findDrugByName(String drug_name) {

        Query query = getSession().createQuery("from Drug d where d.drug_name like :drug_name");

        query.setParameter("drug_name", "%" + drug_name + "%");

        return query.list();
    }
}
