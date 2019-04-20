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
}
