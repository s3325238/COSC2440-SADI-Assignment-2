package controller;

import model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DrugService;

import java.util.List;

@RestController
public class DrugController {

    @Autowired
    DrugService drugService;

    @RequestMapping(path = "/drugs", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Drug> getAllDrug() {
        return drugService.getAllDrugs();
    }

    @RequestMapping(path = "/drugs/add", method = RequestMethod.POST)
    public @ResponseBody Drug add(@RequestBody Drug drug) {

        drugService.saveOrUpdateDrug(drug);

        return drug;

    }

    @RequestMapping(path = "/drugs/update/{id}", method = RequestMethod.PUT)
    public @ResponseBody Drug update(@PathVariable("id") int id, @RequestBody Drug drug) {

        drug.setId(id);

        drugService.saveOrUpdateDrug(drug);

        return drug;

    }

    @RequestMapping(path = "/drugs/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Drug delete(@PathVariable("id") int id) {

        Drug drug = drugService.findDrugById(id);

        drugService.deleteDrug(id);

        return drug;
    }

    @RequestMapping(path = "/drugs/getDrugById/{id}", method = RequestMethod.GET)
    public @ResponseBody Drug getDrugById(@PathVariable("id") int id) {

        Drug drug = drugService.findDrugById(id);

        return drug;
    }

    // Need to modify
    @RequestMapping(path = "/drugs/getDrugByName/{name}", method = RequestMethod.GET)
    public @ResponseBody List<Drug> getDrugByName(@PathVariable("name") String drug_name) {

        List<Drug> drugs = drugService.findDrugByName(drug_name);

        return drugs;
    }

//    @RequestMapping(path = "/drugs", method = RequestMethod.GET)
//    public List<Drug> getAllDrug() {
//        return drugService.getAllDrugs();
//    }
//
//    @RequestMapping(path = "/drugs/search/{id}", method = RequestMethod.GET)
//    public @ResponseBody
//    Drug findDrugById(@PathVariable("id") int id) {
//
//        return drugService.getDrugById(id);
//
//    }
//
//    @RequestMapping(path = "/drugs/getDrugByName/{name}", method = RequestMethod.GET)
//    public @ResponseBody
//    List<Drug> findDrugByName(@PathVariable("name") String drug_name) {
//
//        return drugService.findDrugByName(drug_name);
//
//    }
//
//    // Create
//    @RequestMapping(path = "/drugs", method = RequestMethod.POST)
//    public int addDrug(@RequestBody Drug drug) {
//
//        return drugService.saveDrug(drug);
//
//    }
//
//    // Update
//    @RequestMapping(path = "/drugs/{id}", method = RequestMethod.PUT)
//    public String updateStudent(@PathVariable("id") int id, @RequestBody Drug drug) {
//
//        drug.setId(id);
//
//        return drugService.updateDrug(drug);
//
//    }
//
//    // Delete
//    @RequestMapping(path = "/drugs/delete/{id}", method = RequestMethod.DELETE)
//    public String deleteDrug(@PathVariable("id") int id) {
//
//        Drug drug = drugService.getDrugById(id);
//
//        drugService.deleteDrug(id);
//
//        return "<h1>Data on id: " + drug.getId() + " has been deleted from database.</h1>";
//    }

}
