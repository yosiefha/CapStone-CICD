package com.nashss.se.hms.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nashss.se.hms.dynamodb.models.Diagnosis;
import com.nashss.se.hms.dynamodb.models.Patient;

import static com.nashss.se.hms.dynamodb.models.Diagnosis.SEARCH_ByPatientId_INDEX;
import javax.inject.Inject;
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

    public void deleteDiagnosis(Diagnosis diagnosis){

        dynamoDBMapper.delete(diagnosis);
    }

}
