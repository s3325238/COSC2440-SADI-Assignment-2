package service;

import model.Prescription;

import java.util.List;

public interface PrescriptionService {
    public List<Prescription> getAllPrescriptions();

    public void saveOrUpdatePrescription(Prescription prescription);

    public Prescription findPrescriptionById(int id);

    public List<Prescription> findPrescriptionByVisitId(int id);
}
