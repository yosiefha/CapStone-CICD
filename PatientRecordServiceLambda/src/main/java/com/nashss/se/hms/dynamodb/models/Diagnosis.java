package com.nashss.se.hms.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "diagnoses")
public class Diagnosis {
    public static final String SEARCH_ByPatientId_INDEX = "SearchByPatientIdIndex";
    private String diagnosisId;
    private String  description;
    private String  dateCreated;
    private String healthcareProfessionalId;
    private String  patientId;

    @DynamoDBHashKey(attributeName = "diagnosisId")
    @DynamoDBIndexRangeKey(globalSecondaryIndexName = SEARCH_ByPatientId_INDEX, attributeName = "diagnosisId")
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
    @DynamoDBRangeKey(attributeName = "patientId")
    @DynamoDBIndexHashKey(globalSecondaryIndexNames = SEARCH_ByPatientId_INDEX, attributeName = "patientId")
    public String getPatientId() {
        return patientId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setHealthcareProfessionalId(String healthcareProfessionalId) {
        this.healthcareProfessionalId = healthcareProfessionalId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
