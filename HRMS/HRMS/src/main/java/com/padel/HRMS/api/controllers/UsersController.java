package com.padel.HRMS.api.controllers;

import com.padel.HRMS.business.abstracts.UserService;
import com.padel.HRMS.core.utilities.results.DataResult;
import com.padel.HRMS.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;


    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/getAll")
    @ResponseBody
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }
}
