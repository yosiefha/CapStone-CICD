package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.DeleteMedicationRequest;
import com.nashss.se.hms.activity.results.DeleteMedicationResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.MedicationDAO;
import com.nashss.se.hms.dynamodb.models.Medication;
import com.nashss.se.hms.models.MedicationModel;

import javax.inject.Inject;

public class DeleteMedicationActivity {

    private final MedicationDAO medicationDAO;
    @Inject
    public DeleteMedicationActivity(MedicationDAO medicationDAO) {
        this.medicationDAO = medicationDAO;
    }
    public DeleteMedicationResult handleRequest(final DeleteMedicationRequest deleteMedicationRequest){
        Medication newMedication = new Medication();
        newMedication.setMedicationId(deleteMedicationRequest.getMedicationId());
        MedicationModel medicationModel = new ModelConverter().toMedicationModel(newMedication);
        medicationDAO.deleteMedication(newMedication);
        return DeleteMedicationResult.builder()
                .withMedicationModel(medicationModel)
                .build();
    }
}
