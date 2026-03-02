package com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Entities.User;
import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Requests.LoginRequest;
import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService ; 
@PostMapping("/signup")
public String RegisterUser(@RequestBody User user) {
    return userService.registerUser(user);
}
@PostMapping("/login")
public String loginUser(@RequestBody LoginRequest loginRequest) {
    return userService.loginUser(loginRequest);
}


    
}
