package com.nashss.se.hms.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nashss.se.hms.dynamodb.models.Patient;
import com.nashss.se.hms.exceptions.PatientNotFoundException;



import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nashss.se.hms.dynamodb.models.Patient.SEARCH_ByNAME_INDEX;

public class PatientDAO {

    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public PatientDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDBMapper = dynamoDbMapper;
    }
    public Patient savePatient(Patient patient) {
        this.dynamoDBMapper.save(patient);
        return patient;
    }
    public List<Patient> searchPatient(String firstName, String lastName) {

        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":firstName", new AttributeValue().withS(firstName));
        valueMap.put(":lastName", new AttributeValue().withS(lastName));
        DynamoDBQueryExpression<Patient> queryExpression = new DynamoDBQueryExpression<Patient>()
                .withIndexName(SEARCH_ByNAME_INDEX)
                .withConsistentRead(false)
                .withKeyConditionExpression("firstName = :firstName and lastName = :lastName")
                .withExpressionAttributeValues(valueMap);

        return this.dynamoDBMapper.query(Patient.class, queryExpression);
    }

    public Patient getPatientByPatientId(String patientId){

        Patient patient = this.dynamoDBMapper.load(Patient.class,patientId);
        if (patient == null) {
            throw new PatientNotFoundException("Could not find Patient with id " + patientId);
        }
        return patient;



    }

    public void deletePatient(Patient patient){

        dynamoDBMapper.delete(patient);
    }

}
