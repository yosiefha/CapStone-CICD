package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.models.MedicationModel;

public class CreatePatientMedicationResult {

    private final MedicationModel medicationModel;

    private CreatePatientMedicationResult (MedicationModel medicationModel){

        this.medicationModel = medicationModel;
    }

    public MedicationModel getMedicationModel() {
        return medicationModel;
    }

    @Override
    public String toString() {
        return "CreatePatientMedicationResult{" +
                "medicationModel=" + medicationModel +
                '}';
    }
    public static Builder builder(){

        return new CreatePatientMedicationResult.Builder();
    }
    public static class Builder{
        private MedicationModel medicationModel;

        public Builder withMedication(MedicationModel medicationModel){
            this.medicationModel = medicationModel;
            return this;
        }

        public CreatePatientMedicationResult build(){

            return new CreatePatientMedicationResult(medicationModel);
        }
    }
}
