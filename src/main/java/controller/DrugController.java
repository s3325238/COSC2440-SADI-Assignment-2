package controller;

import model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DrugService;

import java.util.List;

@CrossOrigin
@RestController
public class DrugController {

    @Autowired
    DrugService drugService;

    @RequestMapping(path = "/api/drugs", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Drug> getAllDrug() {
        return drugService.getAllDrugs();
    }

    @RequestMapping(path = "/api/drugs/add", method = RequestMethod.POST)
    public @ResponseBody Drug add(@RequestBody Drug drug) {

        drugService.saveOrUpdateDrug(drug);

        return drug;

    }

    @RequestMapping(path = "/api/drugs/update/{id}", method = RequestMethod.PUT)
    public @ResponseBody Drug update(@PathVariable("id") int id, @RequestBody Drug drug) {

        drug.setId(id);

        drugService.saveOrUpdateDrug(drug);

        return drug;

    }

    @RequestMapping(path = "/api/drugs/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Drug delete(@PathVariable("id") int id) {

        Drug drug = drugService.findDrugById(id);

        drugService.deleteDrug(id);

        return drug;
    }

    @RequestMapping(path = "/api/drugs/getDrugById/{id}", method = RequestMethod.GET)
    public @ResponseBody Drug getDrugById(@PathVariable("id") int id) {

        Drug drug = drugService.findDrugById(id);

        return drug;
    }

    // Need to modify
    @RequestMapping(path = "/api/drugs/getDrugByName/{name}", method = RequestMethod.GET)
    public @ResponseBody List<Drug> getDrugByName(@PathVariable("name") String drug_name) {

        List<Drug> drugs = drugService.findDrugByName(drug_name);

        return drugs;
    }
}
