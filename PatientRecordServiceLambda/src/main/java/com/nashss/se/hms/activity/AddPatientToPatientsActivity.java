package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.AddPatientToPatientsRequest;
import com.nashss.se.hms.activity.results.AddPatientToPatientsResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.PatientDAO;
import com.nashss.se.hms.dynamodb.models.Patient;
import com.nashss.se.hms.models.PatientModel;
import org.apache.logging.log4j.LogManager;


import javax.inject.Inject;
import java.util.UUID;
import java.util.logging.Logger;


public class AddPatientToPatientsActivity {

    private final PatientDAO patientsDAO;

    @Inject
    public AddPatientToPatientsActivity(PatientDAO patientsDAO) {
        this.patientsDAO = patientsDAO;

    }

    public AddPatientToPatientsResult handleRequest(final AddPatientToPatientsRequest addPatientToPatientsRequest) {
       Patient newPatient = new Patient();
       newPatient.setPatientId(UUID.randomUUID().toString());
       newPatient.setFirstName(addPatientToPatientsRequest.getFirstName());
       newPatient.setLastName(addPatientToPatientsRequest.getLastName());
       newPatient.setDateOfBirth(addPatientToPatientsRequest.getDOB());
       newPatient.setContactNumber(addPatientToPatientsRequest.getContactNumber());
       newPatient.setEmailAddress(addPatientToPatientsRequest.getEmailAddress());
       newPatient.setAddress(addPatientToPatientsRequest.getAddress());
       patientsDAO.savePatient(newPatient);

        PatientModel patientModel = new ModelConverter().toPatientModel(newPatient);


       return AddPatientToPatientsResult.builder()
               .withPatient(patientModel)
               .build();


   }
}
