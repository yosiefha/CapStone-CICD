package com.nashss.se.hms.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.hms.activity.requests.GetDiagnosisDetailsRequest;
import com.nashss.se.hms.activity.results.GetDiagnosisDetailsResult;


public class GetDiagnosisDetailsLambda  extends LambdaActivityRunner<GetDiagnosisDetailsRequest, GetDiagnosisDetailsResult>
        implements RequestHandler<LambdaRequest<GetDiagnosisDetailsRequest>, LambdaResponse> {


    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return
     */
    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetDiagnosisDetailsRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromPath(path ->
                        GetDiagnosisDetailsRequest.builder()
                                .withPatientId(path.get("patientId"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetDiagnosisDetailsActivity().handleRequest(request)
        );
    }
}