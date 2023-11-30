package com.nashss.se.hms.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.hms.activity.requests.DeleteDiagnosisRequest;
import com.nashss.se.hms.activity.requests.DeleteMedicationRequest;
import com.nashss.se.hms.activity.results.DeleteMedicationResult;

public class DeleteMedicationLambda extends LambdaActivityRunner<DeleteMedicationRequest, DeleteMedicationResult>
        implements RequestHandler<AuthenticatedLambdaRequest<DeleteMedicationRequest>, LambdaResponse> {


    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return
     */
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeleteMedicationRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        DeleteMedicationRequest.builder()
                                .withMedicationId(path.get("medicationId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideDeleteMedicationActivity().handleRequest(request)
        );
    }
}
