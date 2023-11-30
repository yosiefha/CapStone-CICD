package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.models.DiagnosisModel;

import java.util.List;

public class GetDiagnosisDetailsResult {

    private final List<DiagnosisModel> diagnosisModelList;

    public GetDiagnosisDetailsResult(List<DiagnosisModel> diagnosisModelList) {
        this.diagnosisModelList = diagnosisModelList;
    }

    public List<DiagnosisModel> getDiagnosisModelList() {
        return diagnosisModelList;
    }

    @Override
    public String toString() {
        return "GetDiagnosisDetailsResult{" +
                "diagnosisModelList=" + diagnosisModelList +
                '}';
    }
    public static Builder builder(){
        return  new Builder();
    }

    public static class Builder{

        private List<DiagnosisModel> diagnosisModelList;
        public  Builder withDiagnosisList(List<DiagnosisModel> diagnosisModelList){
            this.diagnosisModelList = diagnosisModelList;
            return this;
        }

        public GetDiagnosisDetailsResult build(){
            return  new GetDiagnosisDetailsResult(diagnosisModelList);
        }
    }
}
