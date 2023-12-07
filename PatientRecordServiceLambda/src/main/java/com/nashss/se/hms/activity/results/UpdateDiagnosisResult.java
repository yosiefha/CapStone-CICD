package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.models.DiagnosisModel;

public class UpdateDiagnosisResult {

    private final DiagnosisModel diagnosisModel;

    public UpdateDiagnosisResult(DiagnosisModel diagnosisModel) {
        this.diagnosisModel = diagnosisModel;
    }

    public DiagnosisModel getDiagnosisModel() {
        return diagnosisModel;
    }

    @Override
    public String toString() {
        return "UpdateDiagnosisResult{" +
                "diagnosisModel=" + diagnosisModel +
                '}';
    }

    public static Builder builder(){
        return new UpdateDiagnosisResult.Builder();
    }
    public static class Builder {
        private DiagnosisModel diagnosisModel;

        public Builder withDiagnosisModel(DiagnosisModel diagnosisModel){
            this.diagnosisModel = diagnosisModel;
            return this;
        }

        public UpdateDiagnosisResult build(){
            return new UpdateDiagnosisResult(diagnosisModel);
        }
    }

}
