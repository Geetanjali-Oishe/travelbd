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

    //    API to get the  all public status
    //    request url example: http://localhost:8080/getAllPublic
    //    response example: [
    //    {
    //        "userId": 2,
    //            "userName": "user2name",
    //            "statusText": "Nothing is more beautiful than the loveliness of the woods before sunrise.\n",
    //            "locationId": 3,
    //            "locationName": "Chittagong"
    //    },
    //    {
    //        "userId": 2,
    //            "userName": "user2name",
    //            "statusText": "You’re only here for a short visit. Don’t hurry, don’t worry. And be sure to smell the flowers along the way.",
    //            "locationId": 3,
    //            "locationName": "Chittagong"
    //    },
    //    {
    //        "userId": 3,
    //            "userName": "user3name",
    //            "statusText": "All life is an experiment. The more experiments you make the better.",
    //            "locationId": 5,
    //            "locationName": "Rajshahi"
    //    }
    //]
    @GetMapping("/getAllPublic")
    @ResponseBody
    public List<UserProfileDto> getPublicStatus()
    {

        return statusService.getAllPublicStatus(2L);
    }

}
