package com.nashss.se.hms.activity;
import com.nashss.se.hms.activity.requests.CreatePatientMedicationRequest;
import com.nashss.se.hms.activity.results.CreatePatientMedicationResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.MedicationDAO;
import com.nashss.se.hms.dynamodb.models.Medication;
import com.nashss.se.hms.models.MedicationModel;


import javax.inject.Inject;

public class CreatePatientMedicationActivity {

    private final MedicationDAO medicationDAO;

    @Inject
    public CreatePatientMedicationActivity(MedicationDAO medicationDAO) {
        this.medicationDAO = medicationDAO;
    }

    public CreatePatientMedicationResult handleRequest(final CreatePatientMedicationRequest createPatientMedicationRequest){
        Medication newMedication =new Medication();
        newMedication.setMedicationId(createPatientMedicationRequest.getMedicationId());
        newMedication.setMedicationName(createPatientMedicationRequest.getMedicationName());
        newMedication.setDosage(createPatientMedicationRequest.getDosage());
        newMedication.setInstructions(createPatientMedicationRequest.getInstructions());
        newMedication.setStartDate(createPatientMedicationRequest.getStartDate());
        newMedication.setEndDate(createPatientMedicationRequest.getEndDate());
        newMedication.setPatientId(createPatientMedicationRequest.getPatientId());
        medicationDAO.savePatientMedicationDetails(newMedication);

        MedicationModel medicationModel = new ModelConverter().toMedicationModel(newMedication);

        return CreatePatientMedicationResult.builder()
                .withMedication(medicationModel)
                .build();



    }
}
