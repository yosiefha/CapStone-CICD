package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.models.PatientModel;

public class GetPatientByPatientIdResult {

    private final PatientModel patientModel;

    public GetPatientByPatientIdResult(PatientModel patientModel) {
        this.patientModel = patientModel;
    }

    public PatientModel getPatientModel() {
        return patientModel;
    }

    @Override
    public String toString() {
        return "GetPatientByPatientIdResult{" +
                "patientModel=" + patientModel +
                '}';
    }

    public  static Builder builder(){
        return  new Builder();
    }

    public  static class Builder{

        private  PatientModel patientModel;
        public Builder withPatientId(PatientModel patientModel){
            this.patientModel =patientModel;
            return this;
        }

        public GetPatientByPatientIdResult build(){
            return  new GetPatientByPatientIdResult(patientModel);
        }

    }
}
