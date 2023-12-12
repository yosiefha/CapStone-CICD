package com.nashss.se.hms.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.hms.activity.requests.GetMedicationDetailsRequest;
import com.nashss.se.hms.activity.results.GetMedicationDetailsResult;

public class GetMedicationDetailsLambda extends LambdaActivityRunner<GetMedicationDetailsRequest, GetMedicationDetailsResult>
        implements RequestHandler<LambdaRequest<GetMedicationDetailsRequest>, LambdaResponse> {
    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return
     */
    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetMedicationDetailsRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetMedicationDetailsRequest.builder()
                                .withPatientId(path.get("patientId"))
                                .build()),
                (request, serviceComponent) ->
                serviceComponent.provideGetMedicationDetailsActivity().handleRequest(request));
    }



}