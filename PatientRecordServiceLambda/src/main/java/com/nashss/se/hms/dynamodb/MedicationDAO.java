package com.nashss.se.hms.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nashss.se.hms.dynamodb.models.Diagnosis;
import com.nashss.se.hms.dynamodb.models.Medication;
import com.nashss.se.hms.dynamodb.models.Patient;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nashss.se.hms.dynamodb.models.Medication.SEARCH_ByPatientId_INDEX;


public class MedicationDAO {

    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public MedicationDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDBMapper = dynamoDbMapper;
    }
    public Medication savePatientMedicationDetails(Medication medication) {
        this.dynamoDBMapper.save(medication);
        return medication;
    }

    public List<Medication> getMedications(String patientId){

        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":patientId", new AttributeValue().withS(patientId));
        DynamoDBQueryExpression<Medication> queryExpression = new DynamoDBQueryExpression<Medication>()
                .withIndexName(SEARCH_ByPatientId_INDEX)
                .withConsistentRead(false)
                .withKeyConditionExpression("patientId = :patientId")
                .withExpressionAttributeValues(valueMap);

        return this.dynamoDBMapper.query(Medication.class, queryExpression);

    }

    public void deleteMedication(Medication medication){

        dynamoDBMapper.delete(medication);
    }

}
