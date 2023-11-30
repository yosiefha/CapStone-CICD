package com.nashss.se.hms.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.nashss.se.hms.activity.requests.DeletePatientRequest;
import com.nashss.se.hms.activity.results.DeletePatientResult;

public class DeletePatientLambda  extends LambdaActivityRunner<DeletePatientRequest, DeletePatientResult>
        implements RequestHandler<AuthenticatedLambdaRequest<DeletePatientRequest>, LambdaResponse> {
    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return
     */
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeletePatientRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        DeletePatientRequest.builder()
                                .withPatientId(path.get("patientId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideDeletePatientActivity().handleRequest(request)
        );
                //                      {
//                        DeletePatientRequest unauthenticatedRequest = input.fromBody(DeletePatientRequest.class);
//                        return input.fromUserClaims(claims ->
//                         DeletePatientRequest.builder()
//                        .withPatientId(unauthenticatedRequest.getPatientId())
//                        .build());
//                }
 //              ,


  //      );
    }
}
