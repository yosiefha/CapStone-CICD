package com.nashss.se.hms.converters;

import com.nashss.se.hms.dynamodb.models.Goal;
import com.nashss.se.hms.dynamodb.models.Patient;
import com.nashss.se.hms.models.GoalModel;
import com.nashss.se.hms.models.PatientModel;

public class ModelConverter {

    public PatientModel toPatientModel(Patient patient){
        return PatientModel.builder()
                .withPatientId(patient.getPatientId())
                .withFirstName(patient.getFirstName())
                .withLastName(patient.getLastName())
                .withDOB(patient.getDateOfBirth())
                .withContactNumber(patient.getContactNumber())
                .withEmailAddress(patient.getEmailAddress())
                .withAddress(patient.getAddress())
                .build();
    }

    public GoalModel toGoalModel(Goal goal) {


        return GoalModel.builder()
                .withGoalName(goal.getGoalName())
                .withUserId(goal.getUserId())
                .withGoalId(goal.getGoalId())
                .withTimePeriod(goal.getTimePeriod())
                .withTarget(goal.getTarget())
                .withUnit(goal.getUnit())
                .build();
    }
}
