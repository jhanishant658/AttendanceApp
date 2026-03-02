package com.attendenceApp.AttendanceApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendenceApp.AttendanceApp.Entities.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance ,Long> {

    int countByUserIdAndStatus(Long userId, String string);

}
