package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.models.DiagnosisModel;


public class DeleteDiagnosisResult {

    private final DiagnosisModel diagnosisModel;

    public DeleteDiagnosisResult(DiagnosisModel diagnosisModel) {
        this.diagnosisModel = diagnosisModel;
    }

    public DiagnosisModel getDiagnosisModel() {
        return diagnosisModel;
    }

    @Override
    public String toString() {
        return "DeleteDiagnosisResult{" +
                "diagnosisModel=" + diagnosisModel +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private DiagnosisModel diagnosisModel;

        public Builder withDiagnosisModel(DiagnosisModel diagnosisModel ) {
            this.diagnosisModel = diagnosisModel;
            return this;
        }

        public DeleteDiagnosisResult build() {return new DeleteDiagnosisResult(diagnosisModel);}
    }
}
