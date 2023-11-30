package com.nashss.se.hms.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "medications")
public class Medication {

    public static final String SEARCH_ByPatientId_INDEX = "SearchByPatientIdIndex";
    private  String medicationId;
    private String medicationName;
    private String dosage;
    private  String  startDate;
    private String endDate;
    private String instructions;
    private String patientId;

    @DynamoDBRangeKey(attributeName = "medicationId")
    @DynamoDBIndexRangeKey(globalSecondaryIndexName = SEARCH_ByPatientId_INDEX, attributeName = "medicationId")
    public String getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(String medicationId) {
        this.medicationId = medicationId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    @DynamoDBHashKey(attributeName = "patientId")
    @DynamoDBIndexHashKey(globalSecondaryIndexNames = SEARCH_ByPatientId_INDEX, attributeName = "patientId")
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
