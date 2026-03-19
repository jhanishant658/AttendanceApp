package com.attendenceApp.AttendanceApp.Repositories;



import com.attendenceApp.AttendanceApp.Entities.Attendance;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttendanceRepository extends MongoRepository<Attendance , String> {

    int countByUserIdAndStatus(String userId, String status);

    boolean existsByUserIdAndDate(String userId, String date);

    Attendance findByUserIdAndDate(String userId, String date);

    List<Attendance> findByUserIdAndDateStartingWith(String userId, String month);
   

}
