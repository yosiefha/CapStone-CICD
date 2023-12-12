package com.nashss.se.hms.converters;
import com.nashss.se.hms.dynamodb.models.Diagnosis;
import com.nashss.se.hms.dynamodb.models.Medication;
import com.nashss.se.hms.dynamodb.models.Patient;
import com.nashss.se.hms.models.DiagnosisModel;
import com.nashss.se.hms.models.MedicationModel;
import com.nashss.se.hms.models.PatientModel;

public class ModelConverter {

    public PatientModel toPatientModel(Patient patient){

            if (patient == null) {
                return null; // Return null if the patient is null
            }
        return PatientModel.builder()
                .withPatientId(patient.getPatientId())
                .withFirstName(patient.getFirstName())
                .withLastName(patient.getLastName())
                .withDOB(patient.getDateOfBirth())
                .withContactNumber(patient.getContactNumber())
                .withEmailAddress(patient.getEmailAddress())
                .withAddress(patient.getAddress())
                .build();
    }

    public DiagnosisModel toDiagnosisModel(Diagnosis diagnosis){
        if (diagnosis == null) {
            return null; // Return null if the patient is null
        }
        return DiagnosisModel.builder()
                .withDiagnosisId(diagnosis.getDiagnosisId())
                .withDescription(diagnosis.getDescription())
                .withDateCreated(diagnosis.getDateCreated())
                .withHealthcareProfessionalId(diagnosis.getHealthcareProfessionalId())
                .withPatientId(diagnosis.getPatientId())
                .build();
    }


    public MedicationModel toMedicationModel(Medication medication) {
        if (medication == null) {
            return null; // Return null if the patient is null
        }

        return  MedicationModel.builder()
                .withMedicationId(medication.getMedicationId())
                .withMedicationName(medication.getMedicationName())
                .withDosage(medication.getDosage())
                .withEndDate(medication.getEndDate())
                .withInstructions(medication.getInstructions())
                .withStartDate(medication.getStartDate())
                .withPatientId(medication.getPatientId())
                .build();
    }
}
