package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.UpdateDiagnosisRequest;
import com.nashss.se.hms.activity.results.UpdateDiagnosisResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.DiagnosisDAO;
import com.nashss.se.hms.dynamodb.models.Diagnosis;

import javax.inject.Inject;

public class UpdateDiagnosisActivity {

    private final DiagnosisDAO diagnosisDAO;

    @Inject
    public UpdateDiagnosisActivity(DiagnosisDAO diagnosisDAO) {
        this.diagnosisDAO = diagnosisDAO;
    }

    public UpdateDiagnosisResult handleRequest(final UpdateDiagnosisRequest updateDiagnosisRequest){
        Diagnosis diagnosis = diagnosisDAO.getDiagnosis(updateDiagnosisRequest.getDiagnosisId());
        String diagnosisId = updateDiagnosisRequest.getDiagnosisId();
        String description = updateDiagnosisRequest.getDescription();
        String dateCreated = updateDiagnosisRequest.getDateCreated();
        String healthcareProfessionalId = updateDiagnosisRequest.getHealthcareProfessionalId();
        String patientId = updateDiagnosisRequest.getPatientId();
        if(description != null){
            diagnosis.setDiagnosisId(description);
        }
        if(dateCreated != null){
            diagnosis.setDateCreated(dateCreated);
        }
        if(healthcareProfessionalId != null){
            diagnosis.setHealthcareProfessionalId(healthcareProfessionalId);
        }

        diagnosis.setDiagnosisId(diagnosisId);
        diagnosis.setPatientId(patientId);
        diagnosis.setDateCreated(dateCreated);
        diagnosis.setHealthcareProfessionalId(healthcareProfessionalId);
        diagnosis.setDescription(description);
        diagnosis = diagnosisDAO.savePatientDiagnoses(diagnosis);
        return UpdateDiagnosisResult.builder()
                .withDiagnosisModel(new ModelConverter().toDiagnosisModel(diagnosis))
                .build();
    }
}
