package com.nashss.se.hms.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.nashss.se.hms.dynamodb.models.Patient;


import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class PatientDAO {

    private final DynamoDBMapper dynamoDBMapper;
    @Inject
    public PatientDAO(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDBMapper = dynamoDbMapper;
    }
    public Patient saveGoal(Patient patient) {
        this.dynamoDBMapper.save(patient);
        return patient;
    }
//    public Patient searchPlaylists(String criteria) {
//        DynamoDBScanExpression dynamoDBScanExpression = new DynamoDBScanExpression();
//
//        if (criteria.length() > 0) {
//            Map<String, AttributeValue> valueMap = new HashMap<>();
//            String valueMapNamePrefix = ":c";
//
//            StringBuilder nameFilterExpression = new StringBuilder();
//            StringBuilder tagsFilterExpression = new StringBuilder();
//
//            for (int i = 0; i < criteria.length(); i++) {
//                valueMap.put(valueMapNamePrefix + i,
//                        new AttributeValue().withS(criteria[i]));
//                nameFilterExpression.append(
//                        filterExpressionPart("playlistName", valueMapNamePrefix, i));
//                tagsFilterExpression.append(
//                        filterExpressionPart("tags", valueMapNamePrefix, i));
//            }
//
//            dynamoDBScanExpression.setExpressionAttributeValues(valueMap);
//            dynamoDBScanExpression.setFilterExpression(
//                    "(" + nameFilterExpression + ") or (" + tagsFilterExpression + ")");
//        }
//
//        return this.dynamoDbMapper.scan(Playlist.class, dynamoDBScanExpression);
//    }

}
