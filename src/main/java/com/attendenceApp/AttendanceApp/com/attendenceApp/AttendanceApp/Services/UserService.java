package com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Entities.User;
import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository ; 
    public String registerUser(User user) {
        // Implement user registration logic here
           userRepository.save(user);
        return "User registered successfully";
    }
    public String loginUser(String email, String password) {
        // Implement user login logic here
        try{
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
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
