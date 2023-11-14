package com.nashss.se.hms.models;

import java.time.LocalDate;
import java.util.Objects;

public class PatientModel {
    private final String patientId;
    private final String firstName;
    private final String lastName;
    private  final String DOB;
    private final String contactNumber;
    private final String emailAddress;
    private final String address;

    public PatientModel(String patientId,String firstName,String lastName,String DOB, String contactNumber,String emailAddress,String address){
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public String getPatientId() {
        return patientId;
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
        return "PatientModel{" +
                "patientId='" + patientId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", contactNumber=" + contactNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientModel)) return false;
        PatientModel that = (PatientModel) o;
        return Objects.equals(getPatientId(), that.getPatientId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getDOB(), that.getDOB());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatientId(), getFirstName(), getLastName(), getDOB());
    }

    public static Builder builder() {
        return  new Builder();
    }
    public static class Builder {

        private String patientId;
        private String firstName;
        private String lastName;
        private String DOB;
        private String contactNumber;
        private String emailAddress;
        private String address;

        public  PatientModel.Builder withPatientId(String patientId){
            this.patientId = patientId;
            return this;
        }

        public PatientModel.Builder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public PatientModel.Builder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public PatientModel.Builder withDOB(String DOB){
            this.DOB = DOB;
            return this;
        }

        public PatientModel.Builder withContactNumber(String contactNumber){
            this.contactNumber = contactNumber;
            return this;
        }

        public PatientModel.Builder withEmailAddress(String emailAddress){
            this.emailAddress = emailAddress;
            return this;
        }

        public PatientModel.Builder withAddress(String address){
            this.address = address;
            return this;
        }

        public PatientModel build() {
            return  new PatientModel(patientId, firstName, lastName, DOB, contactNumber, emailAddress, address);
        }

    }
}
