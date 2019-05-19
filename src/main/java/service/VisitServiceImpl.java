package service;

import dao.VisitDao;
import model.Prescription;
import model.Visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        if (visit.getPrescriptionList() != null){
            for (Prescription prescription : visit.getPrescriptionList()){
                prescription.setVisit(visit);
            }
        }

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

    @Override
    public void deleteVisit(int id) {
        visitDao.deleteVisit(id);
    }

    // Delete by patient id
    @Override
    public void deleteVisitByPatientId(int id) {

        visitDao.deleteVisitByPatientId(id);
    }
}
