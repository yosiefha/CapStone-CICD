package com.nashss.se.hms.activity.requests;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;

@JsonDeserialize(builder = GetMedicationDetailsRequest.Builder.class)
public class GetMedicationDetailsRequest {

    private final String patientId;

    public GetMedicationDetailsRequest(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return "GetMedicationDetailsRequest{" +
                "patientId='" + patientId + '\'' +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }
public static class Builder{

    private String patientId;
    public Builder withPatientId(String patientId){
        this.patientId = patientId;
        return this;
    }

    public GetMedicationDetailsRequest build(){
        return new GetMedicationDetailsRequest(patientId);
    }
}

}