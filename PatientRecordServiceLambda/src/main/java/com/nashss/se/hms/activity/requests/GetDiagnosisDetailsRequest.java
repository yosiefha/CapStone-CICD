package com.nashss.se.hms.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = GetDiagnosisDetailsRequest.Builder.class)
public class GetDiagnosisDetailsRequest {

    private final String patientId;

    public GetDiagnosisDetailsRequest(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return "GetDiagnosisDetailsRequest{" +
                "patientId='" + patientId + '\'' +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }
    @JsonPOJOBuilder
    public  static class Builder{

        private String patientId;

        public Builder withPatientId(String patientId){
            this.patientId = patientId;
            return this;
        }
    public GetDiagnosisDetailsRequest build(){
        return new GetDiagnosisDetailsRequest(patientId);
    }
}
}
