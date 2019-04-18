package controller;

import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PatientService;


import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    // Read all
    @RequestMapping(path = "/patients", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Create
    @RequestMapping(path = "/patients/add", method = RequestMethod.POST)
    public @ResponseBody Patient addPatient(@RequestBody Patient patient) {

        patientService.saveOrUpdatePatient(patient);

        return patient;

    }

    // Update
    @RequestMapping(path = "/patients/update/{id}", method = RequestMethod.PUT)
    public @ResponseBody Patient updatePatient(@PathVariable("id") int id, @RequestBody Patient patient) {

        patient.setId(id);

        patientService.saveOrUpdatePatient(patient);

        return patient;

    }

    // Delete
    @RequestMapping(path = "/patients/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Patient deletePatient(@PathVariable("id") int id) {

        Patient patient = patientService.findPatientById(id);

        patientService.deletePatient(id);

        return patient;
    }

    // Get by id
    @RequestMapping(path = "/patients/getPatientById/{id}", method = RequestMethod.GET)
    public @ResponseBody Patient getDrugById(@PathVariable("id") int id) {

        Patient patient = patientService.findPatientById(id);

        return patient;
    }

    // Get by name
    @RequestMapping(path = "/patients/getPatientByName/{patient_name}", method = RequestMethod.GET)
    public @ResponseBody List<Patient> getDrugByName(@PathVariable("patient_name") String patient_name) {

        List<Patient> patient = patientService.findPatientByName(patient_name);

        return patient;
    }
}
