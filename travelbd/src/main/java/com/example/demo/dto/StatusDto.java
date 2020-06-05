package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Asus on 05-Jun-20.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {

    private Long statusId;
    private String status;
    private Long privacyId;
    private Long locationId;
    private Long userId;

    public Long getStatusId() {
        return this.statusId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public void setPrivacyId(long privacyId) {
        this.privacyId = privacyId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return this.userId;
    }

    public Long getLocationId() {
        return this.locationId;
    }

    public Long getPrivacyId() {
        return this.privacyId;
    }

    public String getStatus() {
        return this.status;
    }
}