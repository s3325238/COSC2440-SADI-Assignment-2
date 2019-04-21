# COSC2440 - Software Architecture: Design & Implementation

###### Student name: Nguyen Huu Tri

###### Student id: s3325238

## OVERVIEW

1. In order for this project works perfectly, I recommend that you need to import druglist-csv.csv into that `Drug` database

2. I have prepared ICD which contain all the disease code as well as name, however, I have not yet implemented the method.

## Structure

1. There will 5 main packages:

    + `config`: contains database name, url, username, and password
    
    + `controller`: contains 3 controllers
    
        + `DrugController`, `PatientController`, and `VisitController`
        
    + `Dao`: Data Access Object
    
        + Fetch data from database
        
    + `Model`: creating table relationship and column in the database
    
2. Controller will call `Service` package function and within `Service` package, it will call to `DAO` ( Data Access Object )

    + If you want to take a look how add/update work, dive into `Service` package instead of `DAO` package.
    

## Controller 

1. Patient Controller:

    + Get full patients in the database `(GET method)`: 

        http://localhost:8080/patients
    + Get patient by his/her id `(GET method)`:
    
        http://localhost:8080/patients/getPatientById/{id}
    
        `param id: patient id in the database you want to get`
    + Get patient by his/her name `(GET method)`:
    
        http://localhost:8080/patients/getPatientByName/{patient_name}
    
        `param patient_name: patient name in the database you want to get`
        
    + Add new patient `(POST method)`:
    
        http://localhost:8080/patients/add
        
        POSTMAN body for add new patient
        
        ```
        {
            "patient_name": "New patient with prescription #1 in visit list",   
            "birth_Date": "YYYY-MM-DD",
            "gender": "Male",
            "address": "702 Nguyen Van Linh",
            "visitList": [
                {
                    "visit_content": "You have successfully add new visit for patient id: 1",   
                    "prescriptionList": [
                        {
                            "main_content": "You have successfully add new main content of prescription for visit id 1",   
                            "optional_content": "You have successfully add new optional content of prescription for visit id 1"
                        }
                    ]
                }
            ]
        }
        ```

    + Update existing patient `(PUT method)`:
    
        http://localhost:8080/patients/update/{id}
        
        `param id: id of the patient in the database you want to update`
        
        **LIMITATION:** 
        
        + if user leaves out any column below, it will insert null into the database
        
            + `patient_name`, `birth_Date`, `gender`, `address`
    
    + Delete existing patient `(DELETE method)`:
        
        http://localhost:8080/patients/delete/{id}
        
        `param id: id of the patient in the database you want to delete`

2. Drug Controller

    + Get full list of drugs (import csv to database) `(GET method)`:
    
        http://localhost:8080/drugs
        
    + Get list of drug by the id (`GET method`):
    
        http://localhost:8080/drugs/getDrugById/{id}
        
        `param id: drug id in the database you want to get`
        
    + Get list of drugs by name `(GET method)`:
        
        http://localhost:8080/drugs/getDrugByName/{drug_name}
        
        `param drug_name: drug name in the database you want to get`
        
    + Add new drug `(POST method)`:
        
        http://localhost:8080/drugs/add
        
        POSTMAN body for add new patient
            
        ```
        {
            "drug_name": "New name to be inserted into drug table",   
        }
        ```
    + Update existing drug `(PUT method)`:
    
        http://localhost:8080/drugs/update/{id}
        
        `param id: id of the drug in the database you want to update`
        
    + Delete existing patient `(DELETE method)`:
            
        http://localhost:8080/drugs/delete/{id}
        
        `param id: id of the drug in the database you want to delete`
        
3. Visit Controller

    + Get full list of visit (un-regarding the patient) `(GET method)`:
        
        http://localhost:8080/visits
        
    + Get visit by id `(GET method)`:
    
        http://localhost:8080/visits/findVisitById/{id}
        
        `param id: visit id in the database you want to get`
        
    + Get list of visit by patient id `(GET method)`:
    
        http://localhost:8080/visits/findVisitByPatientId/{id}
        
        `param id: patient id in the database you want to get`
        
        **LIMITATION**
        
        + Currently only work if there is patient id has been inserted in visit table
        
    + Add new visit by patient id `(POST method)`:
    
        http://localhost:8080/visits/addNewVisitByPatientId/{id}
        
        `param id: patient id that user want to add new visit`
        
        POSTMAN body:
        
        ```
        {
            "visit_content": "Add new visit with visitController",   
            "prescriptionList": [
                {
                    "main_content": "Add new prescription main content with visitController",   
                    "optional_content": "Add new prescription optional content with visitController"
                }
            ]
        }
        ```
    + Update existing visit based on visit id `(PUT method)`:
    
        http://localhost:8080/visits/update/{id}
        
        `param id: id of the visit in the database you want to update`