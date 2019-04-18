package dao;

import model.Drug;

import java.util.List;

public interface DrugDao {

    public List<Drug> getAllDrugs();

    public void saveOrUpdateDrug(Drug drug);

    public void deleteDrug(int id);

    public Drug findDrugById(int id);

    public List<Drug> findDrugByName(String drug_name);
}
