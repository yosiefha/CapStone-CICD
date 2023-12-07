package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.models.MedicationModel;

public class UpdateMedicationResult {

    private final MedicationModel medicationModel;

    public UpdateMedicationResult(MedicationModel medicationModel) {
        this.medicationModel = medicationModel;
    }

    public MedicationModel getMedicationModel() {
        return medicationModel;
    }

    @Override
    public String toString() {
        return "UpdateMedicationResult{" +
                "medicationModel=" + medicationModel +
                '}';
    }

    public static Builder builder(){
        return new UpdateMedicationResult.Builder();
    }
    public static class Builder {
        private MedicationModel medicationModel;

        public Builder withMedicationModel(MedicationModel medicationModel){
            this.medicationModel = medicationModel;
            return this;
        }

        public UpdateMedicationResult build(){
            return new UpdateMedicationResult(medicationModel);
        }
    }
}
