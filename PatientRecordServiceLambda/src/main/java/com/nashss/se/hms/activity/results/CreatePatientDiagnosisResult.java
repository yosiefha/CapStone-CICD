package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.models.DiagnosisModel;

public class CreatePatientDiagnosisResult {

    private final DiagnosisModel diagnosisModel;
    private CreatePatientDiagnosisResult( DiagnosisModel diagnosisModel) {
        this.diagnosisModel = diagnosisModel;

    }

    public DiagnosisModel getDiagnosisModel() {
        return diagnosisModel;
    }

    @Override
    public String toString() {
        return "CreatePatientDiagnosisResult{" +
                "diagnosisModel=" + diagnosisModel +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {

        return new CreatePatientDiagnosisResult.Builder();
    }
    public static class Builder {
        private DiagnosisModel diagnosisModel;

        public Builder withDiagnosis(DiagnosisModel diagnosisModel) {
            this.diagnosisModel = diagnosisModel;
            return this;
        }

        public CreatePatientDiagnosisResult build() {

            return new CreatePatientDiagnosisResult(diagnosisModel);
        }
    }
}
