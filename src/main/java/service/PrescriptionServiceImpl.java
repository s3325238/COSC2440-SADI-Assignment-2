package service;

import dao.PrescriptionDao;
import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {

    PrescriptionDao prescriptionDao;

    @Autowired
    public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
        this.prescriptionDao = prescriptionDao;
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionDao.getAllPrescriptions();
    }

    @Override
    public void saveOrUpdatePrescription(Prescription prescription) {
        prescriptionDao.saveOrUpdatePrescription(prescription);
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
