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
            
            "patient_name": "New patient with prescription #2 in visit list",
            
            "birth_Date": "YYYY-MM-DD",
            
            "gender": "Male",
            
            "address": "702 Nguyen Van Linh",
            
            "visitList": [
                
                {
                    
                    "visit_content": "You have successfully add new visit for patient id: 2",
                    
                    "prescriptionList": [
                        
                        {
                            
                            "main_content": "You have successfully add new main content of prescription for visit id 2",
                            
                            "optional_content": "You have successfully add new optional content of prescription for visit id 2"
                        
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
