package service;

import dao.DrugDao;

import model.Drug;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
public class DrugServiceImpl implements DrugService {

    DrugDao drugDao;

    @Autowired
    public void setDrugDao(DrugDao drugDao) {
        this.drugDao = drugDao;
    }

    @Override
    public List<Drug> getAllDrugs() {
        return drugDao.getAllDrugs();
    }

    @Override
    public void saveOrUpdateDrug(Drug drug) {
        drugDao.saveOrUpdateDrug(drug);
    }

    @Override
    public void deleteDrug(int id) {
        drugDao.deleteDrug(id);
    }

    @Override
    public Drug findDrugById(int id) {
        return drugDao.findDrugById(id);
    }

    @Override
    public List<Drug> findDrugByName(String drug_name) {

        return drugDao.findDrugByName(drug_name);
    }

}
