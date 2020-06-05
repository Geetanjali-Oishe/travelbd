package com.example.demo.controller;

import com.example.demo.dto.ProfileDto;
import com.example.demo.dto.UserProfileDto;
import com.example.demo.model.UserStatus;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Asus on 05-Jun-20.
 */
@Controller
public class PersonalProfileController {
    @Autowired
    StatusService statusService;

    //    API to get the home view with all status (user wise)
    @ResponseBody
    @RequestMapping(value = "getProfile/{id}", method = RequestMethod.GET)
    public List<UserProfileDto> updateOfficeDto(@PathVariable("id") Long id)
    {
        return statusService.getProfile(id);
    }


}
