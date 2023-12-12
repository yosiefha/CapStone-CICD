package com.nashss.se.hms.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.hms.activity.requests.GetPatientByPatientIdRequest;
import com.nashss.se.hms.activity.results.GetPatientByPatientIdResult;

public class GetPatientByPatientIdLambda extends LambdaActivityRunner<GetPatientByPatientIdRequest, GetPatientByPatientIdResult>
    implements RequestHandler<LambdaRequest<GetPatientByPatientIdRequest>,LambdaResponse> {


    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return
     */
    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetPatientByPatientIdRequest> input, Context context) {
        return super.runActivity(
                ()->input.fromPath(path ->
                        GetPatientByPatientIdRequest.builder()
                                .withPatientId(path.get("patientId"))
                                .build()),
                (request,serviceComponent) ->
                        serviceComponent.provideGetPatientByPatientIdActivity().handleRequest(request)
        );
    }
}
