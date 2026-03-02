package com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Entities.User;
import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Repositories.UserRepository;
import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Requests.LoginRequest;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository ; 
    public String registerUser(User user) {
        // Implement user registration logic here
           userRepository.save(user);
        return "User registered successfully";
    }
    public String loginUser(LoginRequest loginRequest) {
        // Implement user login logic here
        try{
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }
        catch(Exception e){
            return "An error occurred during login: " + e.getMessage();
        }
    }
}
