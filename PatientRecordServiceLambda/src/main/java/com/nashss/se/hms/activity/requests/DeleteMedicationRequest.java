package com.nashss.se.hms.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = DeleteMedicationRequest.Builder.class)
public class DeleteMedicationRequest {
    private final String medicationId;

    public DeleteMedicationRequest(String medicationId) {
        this.medicationId = medicationId;
    }

    public String getMedicationId() {
        return medicationId;
    }

    @Override
    public String toString() {
        return "DeleteMedicationRequest{" +
                "medicationId='" + medicationId + '\'' +
                '}';
    }
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {

        private  String medicationId;

        public Builder withMedicationId(String medicationId){
            this.medicationId = medicationId;
            return this;
        }

        public  DeleteMedicationRequest build(){
            return  new DeleteMedicationRequest(medicationId);
        }
    }
}
