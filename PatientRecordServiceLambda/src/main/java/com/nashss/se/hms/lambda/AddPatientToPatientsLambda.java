package com.nashss.se.hms.lambda;

import com.nashss.se.hms.activity.requests.AddPatientToPatientsRequest;
import com.nashss.se.hms.activity.results.AddPatientToPatientsResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AddPatientToPatientsLambda  extends LambdaActivityRunner<AddPatientToPatientsRequest, AddPatientToPatientsResult>
        implements RequestHandler<AuthenticatedLambdaRequest<AddPatientToPatientsRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<AddPatientToPatientsRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    AddPatientToPatientsRequest unauthenticatedRequest = input.fromBody(AddPatientToPatientsRequest.class);
                    return input.fromUserClaims(claims ->
                            AddPatientToPatientsRequest.builder()
                                    .withFirstName(unauthenticatedRequest.getFirstName())
                                    .withLastName(unauthenticatedRequest.getLastName())
                                    .withDOB(unauthenticatedRequest.getDOB())
                                    .withContactNumber(unauthenticatedRequest.getContactNumber())
                                    .withEmailAddress(unauthenticatedRequest.getEmailAddress())
                                    .withAddress(unauthenticatedRequest.getAddress())
                                    .withUserId(claims.get("email"))
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideAddPatientToPatientsActivity().handleRequest(request)
        );
    }
}
