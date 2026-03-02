package com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Response.AttendanceResponse;
import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Services.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    
    @Autowired
    private AttendanceService attendanceService ;
    @PostMapping("/markAttendance")
    void markAttendance(@Param("userId") Long userId , @Param("status") String status) {
        attendanceService.markAttendance(userId, status) ; 
    }
    @GetMapping("/getAttendanceSummary")
    AttendanceResponse getAttendanceSummary(@Param("userId") Long userId) {
        return attendanceService.getAttendanceSummary(userId) ; 
    }
}
