package service;

import model.Visit;

import java.util.List;

public interface VisitService {

    public List<Visit> getAllVisits();

    public void saveOrUpdateVisit(Visit visit);

//    public void deleteVisit(int it);

    public Visit findVisitById(int id);

    public List<Visit> findVisitByPatientId(int id);
}
