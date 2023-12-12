package com.nashss.se.hms.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder =DeletePatientRequest.Builder.class)
public class DeletePatientRequest {

    private final String patientId;

    public DeletePatientRequest(String patientId){
        this.patientId =patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return "DeletePatientRequest{" +
                "patientId='" + patientId + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {

        private String patientId;



        public Builder withPatientId(String patientId) {
            this.patientId = patientId;
            return this;
        }



        public DeletePatientRequest  build() {
            return new DeletePatientRequest(patientId);
        }
    }
}
