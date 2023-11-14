package com.nashss.se.hms.activity.requests;

import com.nashss.se.hms.dynamodb.PatientDAO;

import javax.inject.Inject;

import static com.nashss.se.hms.utils.NullUtils.ifNull;

public class SearchPatientUsingNameRequest {

    private final String criteria;
    private SearchPatientUsingNameRequest(String criteria) {
        this.criteria = criteria;
    }

    public String getCriteria() {
        return criteria;
    }

    @Override
    public String toString() {
        return "SearchPatientUsingNameRequest{" +
                "criteria='" + criteria + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String criteria;

        public Builder withCriteria(String criteria) {
            this.criteria = criteria;
            return this;
        }

        public SearchPatientUsingNameRequest build() {
            return new SearchPatientUsingNameRequest(criteria);
        }
    }





}
