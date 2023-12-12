package com.nashss.se.hms.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.nashss.se.hms.dynamodb.models.Diagnosis;
import com.nashss.se.hms.dynamodb.models.Medication;
import com.nashss.se.hms.dynamodb.models.Patient;
import com.nashss.se.hms.exceptions.DiagnosisNotFoundException;
import com.nashss.se.hms.exceptions.MedicationNotFoundException;

import static com.nashss.se.hms.dynamodb.models.Diagnosis.SEARCH_ByPatientId_INDEX;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagnosisDAO {

    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public DiagnosisDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDBMapper = dynamoDbMapper;
    }
    public Diagnosis savePatientDiagnoses(Diagnosis diagnosis) {
        this.dynamoDBMapper.save(diagnosis);
        return diagnosis;
    }

    public List<Diagnosis> getDiagnoses(String patientId){

        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":patientId", new AttributeValue().withS(patientId));
        DynamoDBQueryExpression<Diagnosis> queryExpression = new DynamoDBQueryExpression<Diagnosis>()
                .withIndexName(SEARCH_ByPatientId_INDEX)
                .withConsistentRead(false)
                .withKeyConditionExpression("patientId = :patientId")
                .withExpressionAttributeValues(valueMap);

        return this.dynamoDBMapper.query(Diagnosis.class, queryExpression);

    }
    public Diagnosis getDiagnosis(String diagnosisId){
        Diagnosis diagnosis = this.dynamoDBMapper.load(Diagnosis.class,diagnosisId);
        if(diagnosis == null){
            throw new DiagnosisNotFoundException("Could not find diagnosis with id " + diagnosisId);
        }
        return diagnosis;
    }

    public void deleteDiagnosis(Diagnosis diagnosis){

        dynamoDBMapper.delete(diagnosis);
    }

    public void deleteDiagnosisBatch(List<Diagnosis> diagnosisList){
        if (diagnosisList != null && diagnosisList.contains(null)) {
            throw new IllegalArgumentException("Input list must not contain null values");
        }

        dynamoDBMapper.batchDelete(diagnosisList);
    }


}
