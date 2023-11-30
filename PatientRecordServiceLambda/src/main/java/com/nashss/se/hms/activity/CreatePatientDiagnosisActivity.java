package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.CreatePatientDiagnosisRequest;
import com.nashss.se.hms.activity.results.CreatePatientDiagnosisResult;
import com.nashss.se.hms.activity.results.SearchPatientByNameResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.DiagnosisDAO;
import com.nashss.se.hms.dynamodb.PatientDAO;
import com.nashss.se.hms.dynamodb.models.Diagnosis;
import com.nashss.se.hms.dynamodb.models.Patient;
import com.nashss.se.hms.models.DiagnosisModel;
import com.nashss.se.hms.models.PatientModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CreatePatientDiagnosisActivity {


    private final DiagnosisDAO diagnosisDAO;

    @Inject
    public  CreatePatientDiagnosisActivity(DiagnosisDAO diagnosisDAO) {
        this.diagnosisDAO = diagnosisDAO;
    }


    public CreatePatientDiagnosisResult handleRequest(final CreatePatientDiagnosisRequest searchPatientDiagnosisRequest) {
        Diagnosis newDiagnosis = new Diagnosis();
        newDiagnosis.setDiagnosisId(searchPatientDiagnosisRequest.getDiagnosisId());
        newDiagnosis.setPatientId(searchPatientDiagnosisRequest.getPatientId());
        newDiagnosis.setDescription(searchPatientDiagnosisRequest.getDescription());
        newDiagnosis.setHealthcareProfessionalId(searchPatientDiagnosisRequest.getHealthcareProfessionalId());
        newDiagnosis.setDateCreated(searchPatientDiagnosisRequest.getDateCreated());
        diagnosisDAO.savePatientDiagnoses(newDiagnosis);


        DiagnosisModel diagnosisModel = new ModelConverter().toDiagnosisModel(newDiagnosis);


        return  CreatePatientDiagnosisResult.builder()
                .withDiagnosis(diagnosisModel)
                .build();
    }
}
