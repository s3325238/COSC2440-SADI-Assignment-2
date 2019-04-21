package dao;

import model.Prescription;

import java.util.List;

public interface PrescriptionDao {

    public List<Prescription> getAllPrescriptions();

    public void saveOrUpdatePrescription(Prescription prescription);

    public Prescription findPrescriptionById(int id);

    public List<Prescription> findPrescriptionByVisitId(int id);
}
