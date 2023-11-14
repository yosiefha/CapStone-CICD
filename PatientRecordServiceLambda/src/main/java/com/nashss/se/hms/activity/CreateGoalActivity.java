package com.nashss.se.hms.activity;

import com.nashss.se.hms.activity.requests.CreateGoalRequest;
import com.nashss.se.hms.activity.results.CreateGoalResult;
import com.nashss.se.hms.converters.ModelConverter;
import com.nashss.se.hms.dynamodb.GoalDao;
import com.nashss.se.hms.dynamodb.models.Goal;
import com.nashss.se.hms.models.GoalModel;


import javax.inject.Inject;


public class CreateGoalActivity {

    private final GoalDao goalDao;

    @Inject
    public CreateGoalActivity(GoalDao goalDao) {
        this.goalDao = goalDao;
    }

    public CreateGoalResult handleRequest(final CreateGoalRequest createGoalRequest) {

        Goal newGoal = new Goal();
        newGoal.setGoalName(createGoalRequest.getGoalName());
        newGoal.setUserId(createGoalRequest.getUserId());
        newGoal.setGoalId(createGoalRequest.getUserId()+createGoalRequest.getGoalName());
        newGoal.setTimePeriod(createGoalRequest.getTimePeriod());
        newGoal.setTarget(createGoalRequest.getTarget());
        newGoal.setUnit(createGoalRequest.getUnit());
        goalDao.saveGoal(newGoal);

        GoalModel goalModel = new ModelConverter().toGoalModel(newGoal);
        return CreateGoalResult.builder()
                .withGoal(goalModel)
                .build();

    }

}
