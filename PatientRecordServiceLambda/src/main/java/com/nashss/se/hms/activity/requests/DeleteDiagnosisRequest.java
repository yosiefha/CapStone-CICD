package com.nashss.se.hms.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
@JsonDeserialize(builder = DeleteDiagnosisRequest.Builder.class)
public class DeleteDiagnosisRequest {

    private final String diagnosisId;

    public DeleteDiagnosisRequest(String diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getDiagnosisId() {
        return diagnosisId;
    }

    @Override
    public String toString() {
        return "DeleteDiagnosisRequest{" +
                "diagnosisId='" + diagnosisId + '\'' +
                '}';
    }
    public static Builder builder() {
        return new Builder();
    }
    @JsonPOJOBuilder
    public static class Builder {

        private String diagnosisId;



        public Builder withDiagnosisId(String diagnosisId) {
            this.diagnosisId = diagnosisId;
            return this;
        }



        public DeleteDiagnosisRequest  build() {

            return new DeleteDiagnosisRequest(diagnosisId);
        }
    }
}
