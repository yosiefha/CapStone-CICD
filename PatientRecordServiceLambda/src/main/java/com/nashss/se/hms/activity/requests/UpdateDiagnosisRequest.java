package com.nashss.se.hms.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UpdateDiagnosisRequest.Builder.class)
public class UpdateDiagnosisRequest {

    private final String diagnosisId;
    private final String description;
    private final String dateCreated;
    private final String healthcareProfessionalId;
    private final String patientId;


    public UpdateDiagnosisRequest(String diagnosisId, String description, String dateCreated, String healthcareProfessionalId, String patientId) {
        this.diagnosisId = diagnosisId;
        this.description = description;
        this.dateCreated = dateCreated;
        this.healthcareProfessionalId = healthcareProfessionalId;
        this.patientId = patientId;
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

    @Override
    public String toString() {
        return "UpdateDiagnosisRequest{" +
                "diagnosisId='" + diagnosisId + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", healthcareProfessionalId='" + healthcareProfessionalId + '\'' +
                ", patientId='" + patientId + '\'' +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }
    @JsonPOJOBuilder
    public static class Builder{

        private String diagnosisId;
        private String description;
        private String dateCreated;
        private String healthcareProfessionalId;
        private String patientId;

        public Builder withDiagnosisId(String diagnosisId){
            this.diagnosisId = diagnosisId;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Builder withDateCreated(String dateCreated){
            this.dateCreated =dateCreated;
            return this;
        }
        public Builder withHealthcareProfessionalId(String healthcareProfessionalId){
            this.healthcareProfessionalId = healthcareProfessionalId;
            return this;
        }

        public Builder withPatientId(String patientId){
            this.patientId = patientId;
            return this;
        }

        public UpdateDiagnosisRequest build(){
            return new UpdateDiagnosisRequest( diagnosisId,  description, dateCreated,healthcareProfessionalId, patientId);
        }


    }


}
