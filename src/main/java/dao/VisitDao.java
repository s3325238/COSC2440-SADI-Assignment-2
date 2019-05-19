package dao;

import model.Patient;
import model.Visit;

import java.util.List;

public interface VisitDao {

    public List<Visit> getAllVisits();

    public void saveOrUpdateVisit(Visit visit);

//    public void addNewVisitByPatientId(Patient patient);

    public void deleteVisitByPatientId(int id);

    public Visit findVisitById(int id);

    public void deleteVisit(int it);

    public List<Visit> findVisitByPatientId(int id);
}
