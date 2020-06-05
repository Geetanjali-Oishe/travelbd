package com.example.demo.controller;

import com.example.demo.dto.UserProfileDto;
import com.example.demo.model.UserStatus;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Asus on 05-Jun-20.
 */
@Controller
public class HomePageController {
    @Autowired
    StatusService statusService;

    //    API to get the home view with all public status
    @GetMapping("/getAllPublic")
    @ResponseBody
    public List<UserProfileDto> getPublicStatus()
    {

        return statusService.getAllPublicStatus(2L);
    }

}
