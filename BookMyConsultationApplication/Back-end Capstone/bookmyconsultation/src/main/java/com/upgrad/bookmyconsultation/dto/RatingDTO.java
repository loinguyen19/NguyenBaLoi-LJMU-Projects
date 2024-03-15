package com.upgrad.bookmyconsultation.dto;

import java.util.UUID;

public class RatingDTO {
    private String id = UUID.randomUUID().toString();
    private String appointmentId;
    private String doctorId;
    private Integer rating;
    private String comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "RatingDTO{" +
                "id='" + id + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}
