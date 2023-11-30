package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.GetDiagnosisDetailsRequest;
import com.nashss.se.hms.activity.results.GetDiagnosisDetailsResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.DiagnosisDAO;
import com.nashss.se.hms.dynamodb.models.Diagnosis;
import com.nashss.se.hms.models.DiagnosisModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetDiagnosisDetailsActivity {

    private  final DiagnosisDAO diagnosisDAO;

    @Inject
    public GetDiagnosisDetailsActivity(DiagnosisDAO diagnosisDAO){
        this.diagnosisDAO = diagnosisDAO;
    }
    public GetDiagnosisDetailsResult handleRequest(final GetDiagnosisDetailsRequest getDiagnosisDetailsRequest){
        String patientId = getDiagnosisDetailsRequest.getPatientId();
        List<Diagnosis> diagnosisList = diagnosisDAO.getDiagnoses(patientId);
        List<DiagnosisModel> diagnosisModelList = new ArrayList<>();
        for(Diagnosis diagnosis : diagnosisList){
            diagnosisModelList.add((new ModelConverter().toDiagnosisModel(diagnosis)));

        }

        return GetDiagnosisDetailsResult.builder()
                .withDiagnosisList(diagnosisModelList)
                .build();
    }
}
