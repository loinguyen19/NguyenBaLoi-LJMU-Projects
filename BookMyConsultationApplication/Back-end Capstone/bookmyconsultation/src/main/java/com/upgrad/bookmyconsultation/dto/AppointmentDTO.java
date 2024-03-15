package com.upgrad.bookmyconsultation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class AppointmentDTO {
    private String appointmentId = UUID.randomUUID().toString();
    private String doctorId;
    private String doctorName;
    private String userId;
    private String userName;
    private String userEmailId;
    private String timeSlot;
    private String status;
    private String appointmentDate;
    private String createdDate;
    private String symptoms;
    private String priorMedicalHistory;

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPriorMedicalHistory() {
        return priorMedicalHistory;
    }

    public void setPriorMedicalHistory(String priorMedicalHistory) {
        this.priorMedicalHistory = priorMedicalHistory;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "appointmentId='" + appointmentId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmailId='" + userEmailId + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", status='" + status + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", priorMedicalHistory='" + priorMedicalHistory + '\'' +
                '}';
    }
}
