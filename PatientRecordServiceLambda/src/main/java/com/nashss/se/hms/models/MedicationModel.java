package com.nashss.se.hms.models;

import lombok.Builder;

import java.util.Objects;

public class MedicationModel {

    private final  String medicationId;
    private final String medicationName;
    private final String dosage;
    private  final String  startDate;
    private final String endDate;
    private final String instructions;
    private final String patientId;

    public MedicationModel(String medicationId, String medicationName, String dosage, String startDate, String endDate, String instructions, String patientId) {
        this.medicationId = medicationId;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.instructions = instructions;
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicationModel)) return false;
        MedicationModel that = (MedicationModel) o;
        return Objects.equals(medicationId, that.medicationId) && Objects.equals(medicationName, that.medicationName) && Objects.equals(dosage, that.dosage) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(instructions, that.instructions) && Objects.equals(patientId, that.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicationId, medicationName, dosage, startDate, endDate, instructions, patientId);
    }

    public String getMedicationId() {
        return medicationId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getPatientId() {
        return patientId;
    }

    public static Builder builder() {
        return  new Builder();
    }
    public static class Builder {

        private String medicationId;
        private String medicationName;
        private String dosage;
        private  String  startDate;
        private String endDate;
        private String instructions;
        private String patientId;

        public Builder withMedicationId(String medicationId){
            this.medicationId = medicationId;
            return this;
        }

        public Builder withMedicationName(String medicationName){
            this.medicationName= medicationName;
            return this;
        }
        public Builder withStartDate(String startDate){
            this.startDate = startDate;
            return this;
        }
        public Builder withEndDate(String endDate){
            this.endDate = endDate;
            return this;
        }

        public Builder withInstructions(String instructions){
            this.instructions = instructions;
            return this;
        }
        public Builder withDosage(String dosage){
            this.dosage = dosage;
            return this;
        }

        public Builder withPatientId(String patientId){
            this.patientId = patientId;
            return this;
        }

        public MedicationModel build(){
            return new MedicationModel(medicationId, medicationName, dosage, startDate, endDate, instructions, patientId);
        }
    }
}
