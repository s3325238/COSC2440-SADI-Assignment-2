package service;

import dao.VisitDao;
import model.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Service
@Transactional
public class VisitServiceImpl implements VisitService {

    VisitDao visitDao;

    @Autowired
    public void setVisitDao(VisitDao visitDao) {
        this.visitDao = visitDao;
    }

    @Override
    public List<Visit> getAllVisits() {
        return visitDao.getAllVisits();
    }

    @Override
    public void saveOrUpdateVisit(Visit visit) {
        visitDao.saveOrUpdateVisit(visit);
    }

    @Override
    public Visit findVisitById(int id) {
        return visitDao.findVisitById(id);
    }

    @Override
    public List<Visit> findVisitByPatientId(int id) {
        return visitDao.findVisitByPatientId(id);
    }
}
