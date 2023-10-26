# Design Document



## _Hospital Management System_ Design

## 1. Problem Statement

_Hospitals are complex organizations with numerous departments, healthcare professionals, and patients to manage. Ensuring efficient patient care, accurate record-keeping, and seamless coordination among various hospital functions is a substantial challenge. Paper-based systems are error-prone, time-consuming, and do not meet the growing demands of modern healthcare facilities. The scope of this project  is to address these challenges by developing a software solution that keeps track of patient records._

## 2. Top Questions to Resolve in Review

### Patient Information Management:
_The existing paper-based patient record systems are prone to errors and are difficult to access , search , organize and update. The proposed system will provide a secure and efficient way to manage patient records, including medical history and  diagnosis._



## 3. Use Cases



#### U1. Registration and Authentication
_As a healthcare professional, I want to register for a secure account and log in to access patient records and add/update medical information._

#### U2. Registration and Authentication
_As a healthcare professional, I want to create electronic records for new patients, including their personal details, medical history, and diagnosis._

#### U3. Registration and Authentication
_As a healthcare professional, I want to search for patient records using various criteria such as name, date of birth, or medical condition for quick and easy access._

#### U4. Registration and Authentication
_As a healthcare professional, I want to be able to update patient records with new diagnoses, treatment plans, and any changes to their medical history._

#### U5. Registration and Authentication
_As a healthcare professional, I want to categorize and organize patient records by department or medical condition to streamline access._

#### U6. Registration and Authentication
_As a healthcare professional, I want to control access to patient records, ensuring that only authorized individuals can view or edit them._

#### U7. Registration and Authentication
_As a healthcare professional, I want the system to securely store patient records, ensuring compliance with healthcare data privacy regulations._

#### U8. Registration and Authentication
_As a healthcare professional, I want to view a patient's complete medical history, including past diagnoses, treatments, and test results, to make informed decisions._

#### U9. Registration and Authentication
_As a healthcare professional, I want to document patient diagnoses in a structured format, making it easier to review and share with other medical staff._

## 4. Project Scope

_The project aims to develop a comprehensive Hospital Management System (HMS) to address the challenges faced by hospitals in managing patient records and improving the efficiency of healthcare operations.
The system will replace existing paper-based patient record systems with a secure, efficient, and digital solution._

### 4.1. In Scope

  .  _The primary focus of the system is to provide a user-friendly and secure way to manage patient information, including personal details, medical history, and diagnoses._

  .  _The system will allow healthcare professionals to create, update, and access patient records with ease._

  .  _Patient records will be organized, categorized, and easily searchable, reducing the risk of errors and improving data accessibility._

### 4.2. Out of Scope

   .  _The system will not handle insurance claims or billing functions. These are typically managed by dedicated billing software._

   .  _The system will not manage patient appointments._

   .  _Managing records unrelated to patient health, such as administrative documents or general hospital records, is beyond the scope of this project._
 
# 5. Proposed Architecture Overview

 The system will be able to create, update, retriwve and delet patient records.
 
 API Gateway and Lambda  will be used to create eight endpoints (GetPatientProfileLambda, CreatePatientProfileLambda, UpdatePatientProfileLambda, DeletPatientProfileLambda,GetPatientRecordLambda, CreatePatientRecordLambda, UpdatePatientRecordLambda and DeletPatientRecordLambda) that will handle the creation, update, delet and 
 retrieval of the patient record.

 Patient information , patient diagnosis ,patient medication and user information will be stored in four different  table in DynamoDB. 

Hospital managment system  will also provide a web interface for users to access the patient records. A main page providing options to log in as a patient or healthecare worker. 

# 6. API

## 6.1. Public Models

### patient
````

            String patientId; // Unique identifier for the patient
            String firstName;
            String lastName;
            Date dateOfBirth;
            String gender;
            String contactNumber;
            String emailAddress;
            String address;
````
            
### Diagnosis
````

             String diagnosisId; // Unique identifier for the diagnosis
             String description;    // Description of the diagnosis
             Date date;             // Date when the diagnosis was made
             String healthcareProfessionalId; // ID of the healthcare professional who made the diagnosis
             String patientId;
````
             
### PatientMedication
````
           
String madicationId      // Unique identifier for the medication
             String medicationName;   // Name of the medication
             String dosage;           // Dosage of the medication
             Date startDate;          // Start date of the medication
             Date endDate;            // End date of the medication
             String instructions;     // Instructions for taking the medication
             String patientId;
            
````

            

## 6.2. _Get Patient Profile Endpoint_

 * Accepts `GET` requests to `/patients/{patientId}`
 * Accepts a patientId and returns the corresponding patientModel
     *  if the given patient is not found throws a PatientNotFoundException.

## 6.3 _Create Patient Profile Endpoint_

 * Accepts `POST` requests to  `/patients`

 * Accepts data to create a new patient with a provided  firstName ,lastName ,dateOfBirth , gender,contactNumber,emailAddress,address and returns new patient.


## 6.4. _Update Patient Profile Endpoint_

  * Accepts `PUT`  requests to `/patients/{patientId}`
  * Accepts data to update a patient profile including . Returns an updated patient profile.
      * if the given patient is not found throws a PatientNotFoundException.

## 6.5. _Delet Patient Profile Endpoint_

  * Accepts `DELETE` requests to `/patients/{patientId}`
  * Accepts data to delete patient  from patients table, returns success status
      * If the given patient is not found, it returns the PatientNotFoundException
  

## 6.6. _Get Patient Record Endpoint_

 * Accepts `GET` requests to `/patients/{patientId}/diagnosis-medication`
 * Accepts a patientId and returns the correspondingpatient record from both the diagnosis  and medication  tables
     *  if the given patient is not found throws a PatientNotFoundException.

## 6.7. _Create Patient Record Endpoint_

* Accepts `POST` requests to `/patients/{patientId}/records`
* Accepts data to create a new patient record using the records type to specify if the type is of diagnosis or  medication .
     *  if the given patient is not found throws a PatientNotFoundException.


## 6.8. _Update Patient Record Endpoint_

 * Accepts `PUT` requests to `/patients/{patientId}/records/{recordId}`
 * Accepts data to update a  patient record using the records type to specify if the type is of diagnosis or  medication  and recordid.
     *  if the given patient is not found throws a PatientNotFoundException.

## 6.9. _Delet Patient Record Endpoint_

 * Accepts `DELETE` requests to `/patients/{patientId}/records/{recordId}`
 * Accepts data to Delet a  patient record using the records type to specify if the type is of diagnosis or medication  and recordid.
     *  if the given patient is not found throws a PatientNotFoundException.
# 7. Tables

### Patients
```
S patientId - hashkey
S firstName 
S lastName
S dateOfBirth
N contactNumber
S emailAddress
S address;
```
### Diagnosis
```
S diagnosisId - hashkey
S description
S date;             
S healthcareProfessionalId
S patientId - rangekey
```
### Diagnosis
```
S diagnosisId - hashkey
S description
S date;             
S healthcareProfessionalId
S patientId - Range key
```
### Medication
````
S medicationId - hashkey          
S medicationName 
S dosage         
S startDate        
S endDate          
S instructions
S patientID - rangekey  
````


# 8. Pages

![IMG_6536](https://github.com/nss-se-cohort-3/CapStone_NSS/assets/42800039/91798a89-8a03-4e3c-bb5f-573eeb2fb11a)

