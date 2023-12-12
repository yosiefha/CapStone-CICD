package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.dynamodb.models.Patient;
import com.nashss.se.hms.models.PatientModel;

public class DeletePatientResult {

    private final PatientModel patientModel;

    public DeletePatientResult(PatientModel patientModel) {
        this.patientModel = patientModel;
    }

    public PatientModel getPatientModel() {
        return patientModel;
    }

    @Override
    public String toString() {
        return "DeletePatientResult{" +
                "patient=" + patientModel +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private PatientModel patientModel;

        public Builder withPatientModel(PatientModel patientModel) {
            this.patientModel = patientModel;
            return this;
        }

        public DeletePatientResult build() {return new DeletePatientResult(patientModel);}
    }
}
