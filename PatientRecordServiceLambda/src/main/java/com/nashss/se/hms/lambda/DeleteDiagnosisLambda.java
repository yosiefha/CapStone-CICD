package com.nashss.se.hms.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.hms.activity.requests.DeleteDiagnosisRequest;
import com.nashss.se.hms.activity.requests.DeletePatientRequest;
import com.nashss.se.hms.activity.results.DeleteDiagnosisResult;


public class DeleteDiagnosisLambda   extends LambdaActivityRunner<DeleteDiagnosisRequest, DeleteDiagnosisResult>
        implements RequestHandler<AuthenticatedLambdaRequest<DeleteDiagnosisRequest>, LambdaResponse> {

    /**
     * @param input   The Lambda Function input
     * @param context The Lambda execution environment context object.
     * @return
     */
    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<DeleteDiagnosisRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    DeleteDiagnosisRequest unauthenticatedRequest = input.fromPath(path -> DeleteDiagnosisRequest.builder()
                            .withDiagnosisId(path.get("diagnosisId"))
                            .build());
                    return input.fromUserClaims(claims ->
                            DeleteDiagnosisRequest.builder()
                                    .withDiagnosisId(unauthenticatedRequest.getDiagnosisId())
                                    .build());
                },
                (request, serviceComponent) ->
                        serviceComponent.provideDeleteDiagnosisActivity().handleRequest(request)
        );
    }
}
