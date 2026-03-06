package com.attendenceApp.AttendanceApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.attendenceApp.AttendanceApp.Entities.Attendance;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance , Long> {

    int countByUserIdAndStatus(Long userId, String status);

    boolean existsByUserIdAndDate(long userId, String string);

    Attendance findByUserIdAndDate(Long userId, String date);

    List<Attendance> findByUserIdAndDateStartingWith(Long userId, String month);
   

}
