package com.attendenceApp.AttendanceApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendenceApp.AttendanceApp.Entities.User;
import com.attendenceApp.AttendanceApp.Repositories.UserRepository;
import com.attendenceApp.AttendanceApp.Requests.LoginRequest;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository ; 
    public User registerUser(User user) {
        // Implement user registration logic here
          User savedUser = userRepository.save(user);
        return savedUser ;
    }
    public User loginUser(LoginRequest loginRequest) {
        // Implement user login logic here
        try{
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return user;
        } else {
            return null ;
        }
    }
        catch(Exception e){
            return null ;
        }
    }
}
