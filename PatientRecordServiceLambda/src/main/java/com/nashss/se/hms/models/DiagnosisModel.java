package com.nashss.se.hms.models;

import java.util.Objects;

public class DiagnosisModel {

    private final String diagnosisId;
    private final String  description;
    private final String  dateCreated;
    private final String healthcareProfessionalId;
    private final String  patientId;

    public DiagnosisModel(String diagnosisId, String description, String dateCreated, String healthcareProfessionalId, String patientId) {
        this.diagnosisId = diagnosisId;
        this.description = description;
        this.dateCreated = dateCreated;
        this.healthcareProfessionalId = healthcareProfessionalId;
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiagnosisModel)) return false;
        DiagnosisModel that = (DiagnosisModel) o;
        return Objects.equals(getDiagnosisId(), that.getDiagnosisId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getDateCreated(), that.getDateCreated()) && Objects.equals(getHealthcareProfessionalId(), that.getHealthcareProfessionalId()) && Objects.equals(getPatientId(), that.getPatientId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiagnosisId(), getDescription(), getDateCreated(), getHealthcareProfessionalId(), getPatientId());
    }

    public String getDiagnosisId() {
        return diagnosisId;
    }

    public String getDescription() {
        return description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getHealthcareProfessionalId() {
        return healthcareProfessionalId;
    }

    public String getPatientId() {
        return patientId;
    }

    public static Builder builder() {
        return  new Builder();
    }
    public static class Builder {

        private String diagnosisId;
        private String  description;
        private String  dateCreated;
        private String healthcareProfessionalId;
        private String  patientId;

        public Builder withDiagnosisId(String diagnosisId){
            this.diagnosisId = diagnosisId;
            return this;
        }
        public Builder withPatientId(String patientId){
            this.patientId = patientId;
            return this;
        }
        public Builder withDescription(String description){
            this.description = description;
            return this;
        }
        public Builder withDateCreated(String dateCreated){
            this.dateCreated = dateCreated;
            return this;
        }

        public Builder withHealthcareProfessionalId(String healthcareProfessionalId){
            this.healthcareProfessionalId= healthcareProfessionalId;
            return this;
        }

        public DiagnosisModel build(){
            return new DiagnosisModel(diagnosisId,description,dateCreated,healthcareProfessionalId,patientId);
        }


    }
}
