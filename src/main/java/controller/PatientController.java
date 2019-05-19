package controller;

import model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PatientService;

import java.util.List;

@CrossOrigin
@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    // Read all
//    @CrossOrigin
    @RequestMapping(path = "/api/patients", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Create
    @RequestMapping(path = "/api/patients/add", method = RequestMethod.POST)
    public @ResponseBody Patient addPatient(@RequestBody Patient patient) {

        patientService.saveOrUpdatePatient(patient);

        return patient;

    }

    // Update
    @RequestMapping(path = "/api/patients/update/{id}", method = RequestMethod.PUT)
    public @ResponseBody Patient updatePatient(@PathVariable("id") int id, @RequestBody Patient patient) {

        patient.setId(id);

        patientService.updatePatient(patient);

        return patient;

    }

    // Delete
    @RequestMapping(path = "/api/patients/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Patient deletePatient(@PathVariable("id") int id) {

        Patient patient = patientService.findPatientById(id);

        patientService.deletePatient(id);

        return patient;
    }

    // Get by id
//    @CrossOrigin
    @RequestMapping(path = "/api/patients/getPatientById/{id}", method = RequestMethod.GET)
    public @ResponseBody Patient getPatientById(@PathVariable("id") int id) {

        Patient patient = patientService.findPatientById(id);

        if (patient != null){
            return patient;
        }else{
            System.out.println("No patient match with that id.");
            return patient;
        }

    }

    // Get by name
    @RequestMapping(path = "/api/patients/getPatientByName/{patient_name}", method = RequestMethod.GET)
    public @ResponseBody List<Patient> getPatientByName(@PathVariable("patient_name") String patient_name) {

        List<Patient> patient = patientService.findPatientByName(patient_name);

        return patient;
    }
}
