package com.nashss.se.hms.activity.results;


import com.nashss.se.hms.models.PatientModel;

public class AddPatientToPatientsResult {
    private final PatientModel patient;
    private AddPatientToPatientsResult(PatientModel patient) {
        this.patient = patient;
    }

    public PatientModel getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "AddPatientToPatientsResult{" +
                "patient=" + patient +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private  PatientModel patient;

        public Builder withPatient( PatientModel patient) {
            this.patient = patient;
            return this;
        }

        public AddPatientToPatientsResult build() {
            return new AddPatientToPatientsResult(patient);
        }
    }
}
