package service;

import dao.DrugDao;

import model.Drug;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
public class DrugServiceImpl implements DrugService {

    DrugDao drugDao;

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Autowired
    public void setDrugDao(DrugDao drugDao) {
        this.drugDao = drugDao;
    }

    @Override
    public List<Drug> getAllDrugs() {
        return drugDao.getAllDrugs();
    }

    @Override
    public void saveOrUpdateDrug(Drug drug) {
        drugDao.saveOrUpdateDrug(drug);
    }

    @Override
    public void deleteDrug(int id) {
        drugDao.deleteDrug(id);
    }

    @Override
    public Drug findDrugById(int id) {
        return drugDao.findDrugById(id);
    }

    @Override
    public List<Drug> findDrugByName(String drug_name) {
        Query query = getSession().createQuery("from Drug d where d.drug_name like :drug_name");

        query.setParameter("drug_name", "%" + drug_name + "%");

        return query.list();
    }

    //    @Autowired
//    private SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public Session getCurrentSessionFactory() {
//        return sessionFactory.getCurrentSession();
//    }
//
//    public List<Drug> getAllDrugs() {
//        Query query = getCurrentSessionFactory().createQuery("from Drug ORDER BY id");
//        return query.list();
//    }
//
//    // Get By Id
//    public Drug getDrugById(int id) {
//        Query query = getCurrentSessionFactory().createQuery("FROM Drug where id = :id");
//        query.setParameter("id", id);
//
//        return (Drug) query.uniqueResult();
//
//    }
//
//    // Get Drug by name
//    public List<Drug> findDrugByName(String drug_name) {
//        Query query = getCurrentSessionFactory().createQuery("from Drug s where s.drug_name like :drug_name");
//
//        query.setParameter("drug_name", "%" + drug_name + "%");
//
//        return query.list();
//    }
//
//    // Save
//    public int saveDrug(Drug drug) {
//
//        getCurrentSessionFactory().save(drug);
//
//        return drug.getId();
//    }
//
//    // Update
//    public String updateDrug(Drug drug) {
//
//        getCurrentSessionFactory().update(drug);
//
//        return "Data on id: " + drug.getId() + " has been updated.";
//    }
//
//    // Delete
//    public void deleteDrug(int id) {
//
//        Drug drug = getCurrentSessionFactory().get(Drug.class, id);
//
//        getCurrentSessionFactory().delete(drug);
//
//    }


}
