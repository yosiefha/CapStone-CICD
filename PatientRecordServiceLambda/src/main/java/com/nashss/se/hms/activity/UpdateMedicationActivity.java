package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.UpdateMedicationRequest;
import com.nashss.se.hms.activity.results.UpdateMedicationResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.MedicationDAO;
import com.nashss.se.hms.dynamodb.models.Medication;

import javax.inject.Inject;

public class UpdateMedicationActivity {

    private final MedicationDAO medicationDAO;

    @Inject
    public UpdateMedicationActivity(MedicationDAO medicationDAO) {
        this.medicationDAO = medicationDAO;
    }

    public UpdateMedicationResult handleRequest(final UpdateMedicationRequest updateMedicationRequest){
        Medication medication =medicationDAO.getMedication(updateMedicationRequest.getMedicationId());
        String medicationId = updateMedicationRequest.getMedicationId();
        String medicationName = updateMedicationRequest.getMedicationName();
        String dosage = updateMedicationRequest.getDosage();
        String startDate = updateMedicationRequest.getStartDate();
        String endDate = updateMedicationRequest.getEndDate();
        String instructions = updateMedicationRequest.getInstructions();
        String patientId = updateMedicationRequest.getPatientId();
        if(medicationName != null){
            medication.setMedicationName(medicationName);
        }
        if(dosage!= null){
            medication.setDosage(dosage);
        }
        if(startDate != null){
            medication.setStartDate(startDate);
        }
        if(endDate != null){
            medication.setEndDate(endDate);
        }
        if(instructions != null){
            medication.setInstructions(instructions);
        }
        medication.setPatientId(patientId);
        medication.setMedicationId(medicationId);
        medication = medicationDAO.savePatientMedicationDetails(medication);
        return  UpdateMedicationResult.builder()
                .withMedicationModel(new ModelConverter().toMedicationModel(medication))
                .build();
    }
}
