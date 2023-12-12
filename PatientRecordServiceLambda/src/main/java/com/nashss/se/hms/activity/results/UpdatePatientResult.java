package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.models.PatientModel;

public class UpdatePatientResult {
    private final PatientModel patientModel;


    public UpdatePatientResult(PatientModel patientModel) {
        this.patientModel = patientModel;
    }

    public PatientModel getPatientModel() {
        return patientModel;
    }

    @Override
    public String toString() {
        return "UpdatePatientResult{" +
                "patientModel=" + patientModel +
                '}';
    }

    public static Builder builder(){
        return new UpdatePatientResult.Builder();
    }
    public static class Builder {
        private PatientModel patientModel;

        public Builder withPatientModel(PatientModel patientModel){
            this.patientModel = patientModel;
            return this;
        }
        public UpdatePatientResult build(){
            return  new UpdatePatientResult(patientModel);
        }


    }
}
