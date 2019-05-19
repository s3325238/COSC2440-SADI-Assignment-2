package service;

import model.Visit;

import java.util.List;

public interface VisitService {

    public List<Visit> getAllVisits();

    public void saveOrUpdateVisit(Visit visit);

    public Visit findVisitById(int id);

    public List<Visit> findVisitByPatientId(int id);

    public void deleteVisit(int id);

    public void deleteVisitByPatientId(int it);
}
