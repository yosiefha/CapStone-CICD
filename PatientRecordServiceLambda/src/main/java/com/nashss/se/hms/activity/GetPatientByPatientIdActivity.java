package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.GetPatientByPatientIdRequest;
import com.nashss.se.hms.activity.results.GetPatientByPatientIdResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.PatientDAO;
import com.nashss.se.hms.dynamodb.models.Patient;
import com.nashss.se.hms.models.PatientModel;

import javax.inject.Inject;

public class GetPatientByPatientIdActivity {

    private final PatientDAO patientDAO;
    @Inject
    public GetPatientByPatientIdActivity(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    public GetPatientByPatientIdResult handleRequest(final GetPatientByPatientIdRequest getPatientByPatientIdRequest){
       String patientId = getPatientByPatientIdRequest.getPatientId();
       Patient patient = patientDAO.getPatientByPatientId(patientId);
       PatientModel patientModel = new ModelConverter().toPatientModel(patient);

        return GetPatientByPatientIdResult.builder()
                .withPatientId(patientModel)
                .build();
    }
}
