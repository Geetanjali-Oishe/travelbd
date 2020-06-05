package com.example.demo.service.impl;

import com.example.demo.dto.StatusDto;
import com.example.demo.dto.UserProfileDto;
import com.example.demo.model.Location;
import com.example.demo.model.Privacy;
import com.example.demo.model.UserStatus;
import com.example.demo.model.Users;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.PrivacyRepository;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.StatusService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Asus on 05-Jun-20.
 */
@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    PrivacyRepository privacyRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Privacy> getAllPrivacy() {
        return privacyRepository.findAll();
    }

    @Override
    public void postStatus(StatusDto statusDto) {
        UserStatus userStatus = new UserStatus();
        if (statusDto.getStatusId() != -1L) {
            Optional<UserStatus> sts = statusRepository.findById(statusDto.getStatusId());
            userStatus = sts.get();
        }

        userStatus.setText(statusDto.getStatus());
        userStatus.setUserId(statusDto.getUserId());
        userStatus.setLocationId(statusDto.getLocationId());
        userStatus.setPrivacyId(statusDto.getPrivacyId());
        statusRepository.save(userStatus);
    }

    @Override
    public List<UserProfileDto> getAllPublicStatus(Long publicId) {
        List<UserStatus> userStatuses = statusRepository.findByPrivacyId(publicId);
        List<UserProfileDto> userProfileDtos = new ArrayList<>();

        for (UserStatus temp : userStatuses) {
            UserProfileDto userProfileDto = new UserProfileDto();
            userProfileDto.setLocationId(temp.getLocationId());
            Optional<Location> location = locationRepository.findById(temp.getLocationId());
            userProfileDto.setLocationName(location.get().getName());
            userProfileDto.setStatusText(temp.getText());
            userProfileDto.setUserId(temp.getUserId());
            Optional<Users> user= userRepository.findById(temp.getUserId());
            userProfileDto.setUserName(user.get().getName());
            userProfileDtos.add(userProfileDto);
        }

        return userProfileDtos;
    }

    @Override
    public List<UserStatus> getAllStatus() {
        return statusRepository.findAll();
    }

    @Override
    public List<UserProfileDto> getProfile(Long userId) {
        List<UserStatus> userStatuses = statusRepository.findByUserId(userId);

        List<UserProfileDto> userProfileDtos = new ArrayList<>();

        for (UserStatus temp : userStatuses) {
            UserProfileDto userProfileDto = new UserProfileDto();
            userProfileDto.setLocationId(temp.getLocationId());
            Optional<Location> location = locationRepository.findById(temp.getLocationId());
            userProfileDto.setLocationName(location.get().getName());
            userProfileDto.setStatusText(temp.getText());
            userProfileDto.setUserId(temp.getUserId());
            Optional<Users> user= userRepository.findById(temp.getUserId());
            userProfileDto.setUserName(user.get().getName());
            userProfileDtos.add(userProfileDto);
        }

        return userProfileDtos;
//        return statusRepository.findAll();
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}
