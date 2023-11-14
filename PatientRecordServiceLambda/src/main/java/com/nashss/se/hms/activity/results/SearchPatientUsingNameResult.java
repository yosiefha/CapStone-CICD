package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.dynamodb.models.Patient;
import lombok.Builder;

public class SearchPatientUsingNameResult {
    private final Patient patient;

    private SearchPatientUsingNameResult(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "SearchPatientUsingNameResult{" +
                "patient=" + patient +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Patient patient ;

        public Builder withPatient(Patient patient) {
            this.patient = patient;
            return this;
        }

        public SearchPatientUsingNameResult build() {
            return new SearchPatientUsingNameResult(patient);
        }
    }

}
