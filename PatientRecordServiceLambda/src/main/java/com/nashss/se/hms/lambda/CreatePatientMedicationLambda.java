package com.nashss.se.hms.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.hms.activity.requests.CreatePatientMedicationRequest;
import com.nashss.se.hms.activity.results.CreatePatientMedicationResult;


import java.util.UUID;


public class CreatePatientMedicationLambda  extends LambdaActivityRunner<CreatePatientMedicationRequest, CreatePatientMedicationResult>
        implements RequestHandler<AuthenticatedLambdaRequest<CreatePatientMedicationRequest>, LambdaResponse> {


    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreatePatientMedicationRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    CreatePatientMedicationRequest unauthenticatedRequest = input.fromBody(CreatePatientMedicationRequest.class);
                    return input.fromUserClaims(claims ->
                            CreatePatientMedicationRequest.builder()
                                    .withMedicationId(UUID.randomUUID().toString())
                                    .withMedicationName(unauthenticatedRequest.getMedicationName())
                                    .withDosage(unauthenticatedRequest.getDosage())
                                    .withStartDate(unauthenticatedRequest.getStartDate())
                                    .withEndDate(unauthenticatedRequest.getEndDate())
                                    .withInstructions(unauthenticatedRequest.getInstructions())
                                    .withPatientId(unauthenticatedRequest.getPatientId())
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideCreatePatientMedicationActivity().handleRequest(request)
        );
    }
}
