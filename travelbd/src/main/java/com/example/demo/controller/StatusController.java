package com.example.demo.controller;

import com.example.demo.dto.StatusDto;
import com.example.demo.model.Location;
import com.example.demo.model.Privacy;
import com.example.demo.model.UserStatus;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Asus on 05-Jun-20.
 */
@Controller
public class StatusController {
    @Autowired
    StatusService statusService;

    //    Go to the status page
    @GetMapping("/getStatusPage")
    public String getStatusPage()
    {
        return "new_status";
    }

    //    API to get the privacy options
    @GetMapping("/getPrivacy")
    @ResponseBody
    public List<Privacy> getPrivacy()
    {
        return statusService.getAllPrivacy();
    }


    //    API to get the list of locations
    @GetMapping("/getLocationList")
    @ResponseBody
    public List<Location> getLocations() {
        return statusService.getAllLocations();
    }


    //    API to post a status
    @RequestMapping(value = "/postStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StatusDto> postStatus(@RequestBody StatusDto statusDto)
    {
        statusService.postStatus(statusDto);
        return new ResponseEntity<StatusDto>(statusDto, HttpStatus.OK);
    }

    //    API to get the privacy options
    @GetMapping("/initial")
    public String getInitialView()
    {
        return "initial";
    }
}
