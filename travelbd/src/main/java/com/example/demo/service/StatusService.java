package com.example.demo.service;

import com.example.demo.dto.StatusDto;
import com.example.demo.dto.UserProfileDto;
import com.example.demo.model.Location;
import com.example.demo.model.Privacy;
import com.example.demo.model.UserStatus;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

/**
 * Created by Asus on 05-Jun-20.
 */

public interface StatusService {
    List<Location> getAllLocations();
    List<Privacy> getAllPrivacy();
    void postStatus(StatusDto statusDto);
    List<UserProfileDto> getAllPublicStatus (Long publicId);
    List<UserStatus> getAllStatus();
    List<UserProfileDto> getProfile(Long userId);
}
