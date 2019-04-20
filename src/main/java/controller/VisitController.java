package controller;


import model.Patient;
import model.Visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PatientService;
import service.VisitService;

import java.util.List;

@RestController
public class VisitController {

    @Autowired
    VisitService visitService;

    @Autowired
    PatientService patientService;

    // Read all
    @RequestMapping(path = "/visits", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Visit> getAllPatients() {
        return visitService.getAllVisits();
    }

    // Create new visit based on patient id
    @RequestMapping(path = "/visits/addNewVisitByPatientId/{id}", method = RequestMethod.POST)
    public @ResponseBody Visit addNewVisitByPatientId (@PathVariable("id") int id, @RequestBody Visit visit){

        Patient patient = patientService.findPatientById(id);

        visit.setPatient(patient);

        visitService.saveOrUpdateVisit(visit);

        return visit;

    }

    // Find Visit by id
    @RequestMapping(path = "/visits/findVisitById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody Visit findVisitById (@PathVariable("id") int id){
        return visitService.findVisitById(id);
    }

    // Find visit by patient id
    @RequestMapping(path = "/visits/findVisitByPatientId/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Visit> findVisitByPatientId(@PathVariable("id") int id){

        return visitService.findVisitByPatientId(id);

    }
}
