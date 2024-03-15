package com.upgrad.bookmyconsultation.dto;

import com.upgrad.bookmyconsultation.entity.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;

public class UserAuthTokenDTO {
    private long id;
    private User user;
    private String accessToken;
    private ZonedDateTime loginAt;
    private ZonedDateTime expiresAt;
    private ZonedDateTime logoutAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public ZonedDateTime getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(ZonedDateTime loginAt) {
        this.loginAt = loginAt;
    }

    public ZonedDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(ZonedDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public ZonedDateTime getLogoutAt() {
        return logoutAt;
    }

    public void setLogoutAt(ZonedDateTime logoutAt) {
        this.logoutAt = logoutAt;
    }

    @Override
    public String toString() {
        return "UserAuthTokenDTO{" +
                "id=" + id +
                ", user=" + user +
                ", accessToken='" + accessToken + '\'' +
                ", loginAt=" + loginAt +
                ", expiresAt=" + expiresAt +
                ", logoutAt=" + logoutAt +
                '}';
    }
}
