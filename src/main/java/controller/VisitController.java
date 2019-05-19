package controller;


import model.Patient;
import model.Visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PatientService;
import service.VisitService;

import java.util.List;

@CrossOrigin
@RestController
public class VisitController {

    @Autowired
    VisitService visitService;

    @Autowired
    PatientService patientService;

    // Read all
    @RequestMapping(path = "/api/visits", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Visit> getAllPatients() {
        return visitService.getAllVisits();
    }

    // Create new visit based on patient id
    @RequestMapping(path = "/api/visits/addNewVisitByPatientId/{id}", method = RequestMethod.POST)
    public @ResponseBody Visit addNewVisitByPatientId (@PathVariable("id") int id, @RequestBody Visit visit){

        Patient patient = patientService.findPatientById(id);

        visit.setPatient(patient);

        visitService.saveOrUpdateVisit(visit);

        return visit;

    }

    @RequestMapping(path = "/api/visits/update/{id}", method = RequestMethod.PUT)
    public @ResponseBody String updateVisit(@PathVariable("id") int visit_id, @RequestBody Visit visit){

        Visit visit1 = visitService.findVisitById(visit_id);

        if (visit1 != null){
            visit.setId(visit_id);

            visitService.saveOrUpdateVisit(visit);

            return "Visit data has been updated at id: " + visit.getId();
        }else {
            return "No visit has been found with the id: " + visit_id;
        }

    }

    // Find Visit by id
    @RequestMapping(path = "/api/visits/findVisitById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody Visit findVisitById (@PathVariable("id") int id){
        return visitService.findVisitById(id);
    }

    // Find visit by patient id
    @RequestMapping(path = "/api/visits/findVisitByPatientId/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Visit> findVisitByPatientId(@PathVariable("id") int id){

        return visitService.findVisitByPatientId(id);

    }

    // Delete
    @RequestMapping(path = "/api/visits/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Visit deleteVisit(@PathVariable("id") int id) {

        Visit visit = visitService.findVisitById(id);

        visitService.deleteVisit(id);

        return visit;
    }

    // @id param: Patient ID
    @RequestMapping(path = "/api/visits/deleteVisitByPatientId/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteVisitByPatientId(@PathVariable("id") int id){

        // TODO: Find visit by patient id with param -> type return: list
        // TODO: Get id from list[id]
        // TODO: Find visit based on list[id]
        // TODO: DELETE visit
        visitService.deleteVisitByPatientId(id);

        return "Visit has been deleted";

    }
}
