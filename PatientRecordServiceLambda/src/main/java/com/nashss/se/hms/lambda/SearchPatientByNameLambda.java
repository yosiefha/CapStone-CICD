package com.nashss.se.hms.lambda;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


import com.nashss.se.hms.activity.requests.SearchPatientByNameRequest;
import com.nashss.se.hms.activity.results.SearchPatientByNameResult;


public class SearchPatientByNameLambda
        extends LambdaActivityRunner<SearchPatientByNameRequest, SearchPatientByNameResult>
        implements RequestHandler<LambdaRequest<SearchPatientByNameRequest>, LambdaResponse> {


    @Override
    public LambdaResponse handleRequest(LambdaRequest<SearchPatientByNameRequest> input, Context context) {
       return  super.runActivity(
               () -> input.fromPath(path ->
                       SearchPatientByNameRequest.builder()
                               .withFirstName(path.get("firstName"))
                               .withLastName(path.get("lastName"))
                               .build()),
               (request, serviceComponent) ->
                       serviceComponent.provideSearchPatientByNameActivity().handleRequest(request)
       );
    }
}
