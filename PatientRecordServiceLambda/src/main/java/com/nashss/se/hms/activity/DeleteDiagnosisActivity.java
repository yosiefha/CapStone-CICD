package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.DeleteDiagnosisRequest;
import com.nashss.se.hms.activity.results.DeleteDiagnosisResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.DiagnosisDAO;
import com.nashss.se.hms.dynamodb.models.Diagnosis;
import com.nashss.se.hms.models.DiagnosisModel;

import javax.inject.Inject;

public class DeleteDiagnosisActivity {

    private final DiagnosisDAO diagnosisDAO;
    @Inject
    public DeleteDiagnosisActivity(DiagnosisDAO diagnosisDAO) {
        this.diagnosisDAO = diagnosisDAO;
    }

    public DeleteDiagnosisResult handleRequest(final DeleteDiagnosisRequest deleteDiagnosisRequest){
        Diagnosis newDiagnosis = new Diagnosis();
        newDiagnosis.setDiagnosisId(deleteDiagnosisRequest.getDiagnosisId());
        diagnosisDAO.deleteDiagnosis(newDiagnosis);
        DiagnosisModel diagnosisModel = new ModelConverter().toDiagnosisModel(newDiagnosis);

        return  DeleteDiagnosisResult.builder()
                .withDiagnosisModel(diagnosisModel)
                .build();
    }
}
