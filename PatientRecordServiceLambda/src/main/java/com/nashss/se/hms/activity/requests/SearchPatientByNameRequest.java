package com.nashss.se.hms.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = SearchPatientByNameRequest.Builder.class)
public class SearchPatientByNameRequest {


    private final String firstName;
    private final String lastName;


    public SearchPatientByNameRequest(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;

    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public String toString() {
        return "SearchPatientByNameRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {

        private String firstName;
        private String lastName;

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }



        public SearchPatientByNameRequest build() {
            return new SearchPatientByNameRequest(firstName, lastName);
        }
    }

}
