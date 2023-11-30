package com.nashss.se.hms.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = AddPatientToPatientsRequest.Builder.class)
public class AddPatientToPatientsRequest {

    private final String firstName;
    private final String lastName;
    private  final String DOB;
    private final String contactNumber;
    private final String emailAddress;
    private final String address;

    private AddPatientToPatientsRequest(String firstName,
                                        String lastName, String DOB,
                                        String contactNumber, String emailAddress,
                                        String address){


        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }




    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return "AddPatientToPatientsRequest{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB='" + DOB + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }
    @JsonPOJOBuilder
    public static class Builder {

        private String firstName;
        private String lastName;
        private String DOB;
        private String contactNumber;
        private String emailAddress;
        private String address;


        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withDOB( String DOB) {
            this.DOB = DOB;
            return this;
        }

        public Builder withContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder withEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }
        public AddPatientToPatientsRequest build() {
            return new AddPatientToPatientsRequest(firstName, lastName, DOB, contactNumber,emailAddress,address);
        }

    }

}
