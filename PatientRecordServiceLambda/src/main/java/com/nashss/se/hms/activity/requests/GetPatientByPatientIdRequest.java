package com.nashss.se.hms.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder =GetPatientByPatientIdRequest.Builder.class)
public class GetPatientByPatientIdRequest {

    private final String patientId;
    public GetPatientByPatientIdRequest(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return "getPatientByPatientIdRequest{" +
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
        public GetPatientByPatientIdRequest build() {
            return new GetPatientByPatientIdRequest(patientId);
        }
    }
}
