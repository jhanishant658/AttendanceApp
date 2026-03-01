package com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long>{

    User findByEmail(String email);
   
}
