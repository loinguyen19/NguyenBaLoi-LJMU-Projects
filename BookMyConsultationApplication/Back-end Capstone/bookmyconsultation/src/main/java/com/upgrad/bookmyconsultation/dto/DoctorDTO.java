package com.upgrad.bookmyconsultation.dto;

import com.upgrad.bookmyconsultation.entity.Address;
import com.upgrad.bookmyconsultation.enums.Speciality;

import javax.persistence.*;
import java.util.UUID;

public class DoctorDTO {
    private String id = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private Speciality speciality;
    private String dob;
    private Address address;
    private String mobile;
    private String emailId;
    private String pan;
    private String highestQualification;
    private String college;
    private Integer totalYearsOfExp;
    private Double rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Integer getTotalYearsOfExp() {
        return totalYearsOfExp;
    }

    public void setTotalYearsOfExp(Integer totalYearsOfExp) {
        this.totalYearsOfExp = totalYearsOfExp;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality=" + speciality +
                ", dob='" + dob + '\'' +
                ", address=" + address +
                ", mobile='" + mobile + '\'' +
                ", emailId='" + emailId + '\'' +
                ", pan='" + pan + '\'' +
                ", highestQualification='" + highestQualification + '\'' +
                ", college='" + college + '\'' +
                ", totalYearsOfExp=" + totalYearsOfExp +
                ", rating=" + rating +
                '}';
    }
}
