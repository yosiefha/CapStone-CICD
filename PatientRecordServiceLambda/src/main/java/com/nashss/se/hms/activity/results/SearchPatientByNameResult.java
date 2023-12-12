package com.nashss.se.hms.activity.results;

import com.nashss.se.hms.dynamodb.models.Patient;
import com.nashss.se.hms.models.PatientModel;

import java.util.List;

public class SearchPatientByNameResult {
    private final List<PatientModel> patientModelList;

    private SearchPatientByNameResult(List<PatientModel> patientModelList) {

        this.patientModelList= patientModelList;
    }

    public List<PatientModel> getPatientModelList() {
        return patientModelList;
    }

    @Override
    public String toString() {
        return "SearchPatientByNameResult{" +
                "patientModelList=" + patientModelList +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<PatientModel> patientModelList ;

        public Builder withPatientList(List<PatientModel> patientModelList) {
            this.patientModelList = patientModelList;
            return this;
        }

        public SearchPatientByNameResult build() {

            return new SearchPatientByNameResult(patientModelList);
        }
    }

}
