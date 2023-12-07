package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.UpdatePatientRequest;
import com.nashss.se.hms.activity.results.UpdatePatientResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.PatientDAO;
import com.nashss.se.hms.dynamodb.models.Patient;

import javax.inject.Inject;

public class UpdatePatientActivity {

    private final PatientDAO patientDAO;
    @Inject
    public UpdatePatientActivity(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }



   public UpdatePatientResult handleRequest(final UpdatePatientRequest updatePatientRequest){

       Patient patient = patientDAO.getPatientByPatientId(updatePatientRequest.getPatientId());
       String patientId = updatePatientRequest.getPatientId();
       String firstName = updatePatientRequest.getFirstName();
       String lastName = updatePatientRequest.getLastName();
       String DOB = updatePatientRequest.getDOB();
       String contactNumber = updatePatientRequest.getContactNumber();
       String emailAddress = updatePatientRequest.getEmailAddress();
       String address = updatePatientRequest.getAddress();

       if(firstName != null){
           patient.setFirstName(firstName);
       }
       if(lastName != null){
           patient.setLastName(lastName);
       }
       if(DOB != null){
           patient.setDateOfBirth(DOB);
       }
       if(contactNumber != null){
           patient.setContactNumber(contactNumber);
       }
       if(emailAddress != null){
           patient.setEmailAddress(emailAddress);
       }
       if(address != null){
           patient.setAddress(address);
       }
       patient.setPatientId(patientId);
       patient =patientDAO.savePatient(patient);

       return UpdatePatientResult.builder()
               .withPatientModel(new ModelConverter().toPatientModel(patient))
               .build();



   }
}
