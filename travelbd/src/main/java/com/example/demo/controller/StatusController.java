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

    //    API to get the privacy options
    //    request url example: http://localhost:8080/getPrivacy
    //    response example: [
    //    {
    //        "id": 2,
    //            "name": "Public"
    //    },
    //    {
    //        "id": 3,
    //            "name": "Private"
    //    }
    //]
    @GetMapping("/getPrivacy")
    @ResponseBody
    public List<Privacy> getPrivacy()
    {
        return statusService.getAllPrivacy();
    }


    //    API to get the list of locations
    //    request example: http://localhost:8080/getLocationList
    //    response example:
    //            [
    //    {
    //        "id": 1,
    //            "name": "Coxs Bazar"
    //    },
    //    {
    //        "id": 2,
    //            "name": "Dhaka"
    //    },
    //    {
    //        "id": 3,
    //            "name": "Chittagong"
    //    },
    //    {
    //        "id": 4,
    //            "name": "Khulna"
    //    }}
    @GetMapping("/getLocationList")
    @ResponseBody
    public List<Location> getLocations() {
        return statusService.getAllLocations();
    }


    //    API to post a status
    //    request url example:http://localhost:8080/postStatus
    //    request body example: {
    //        "statusId":"14",
    //                "status":"test status",
    //                "privacyId":"3",
    //                "locationId":"4",
    //                "userId":"3"
    //    }

    @RequestMapping(value = "/postStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StatusDto> postStatus(@RequestBody StatusDto statusDto)
    {
        statusService.postStatus(statusDto);
        return new ResponseEntity<StatusDto>(statusDto, HttpStatus.OK);
    }

    //    API to get the initial page after login
    @GetMapping("/initial")
    public String getInitialView()
    {
        return "initial";
    }

    //    Go to the status page
    @GetMapping("/getStatusPage")
    public String getStatusPage()
    {
        return "new_status";
    }
}
