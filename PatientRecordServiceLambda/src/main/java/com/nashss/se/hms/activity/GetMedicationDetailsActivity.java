package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.GetMedicationDetailsRequest;
import com.nashss.se.hms.activity.results.GetMedicationDetailsResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.MedicationDAO;
import com.nashss.se.hms.dynamodb.models.Medication;
import com.nashss.se.hms.models.MedicationModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetMedicationDetailsActivity {

    private final MedicationDAO medicationDAO;

    @Inject
    public GetMedicationDetailsActivity(MedicationDAO medicationDAO){
        this.medicationDAO = medicationDAO;
    }

    public GetMedicationDetailsResult handleRequest(final GetMedicationDetailsRequest  getMedicationDetailsRequest){
        String patientId = getMedicationDetailsRequest.getPatientId();
        List<Medication> medicationList = medicationDAO.getMedications(patientId);
        List<MedicationModel> medicationModelList = new ArrayList<>();
        for(Medication medication : medicationList){
            medicationModelList.add(new ModelConverter().toMedicationModel(medication));
        }
        return GetMedicationDetailsResult.builder()
                .withMedicationList(medicationModelList)
                .build();
    }
}
