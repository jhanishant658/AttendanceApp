package com.attendenceApp.AttendanceApp.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendenceApp.AttendanceApp.Requests.AddOldAttendance;
import com.attendenceApp.AttendanceApp.Requests.AttendanceRequest;
import com.attendenceApp.AttendanceApp.Response.AttendanceResponse;
import com.attendenceApp.AttendanceApp.Services.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService ; 
  @PostMapping("/mark")
  public String markAttendance(@RequestBody AttendanceRequest attendanceRequest) {
    
    return attendanceService.markAttendance(attendanceRequest);
  }
@GetMapping("/summary")
     public AttendanceResponse getAttendanceSummary(@RequestParam("userId") Long userId) {
        return attendanceService.getAttendanceSummary(userId);
     }
     @PostMapping("/addOldAttendance")
      public String addOldAttendance(@RequestBody AddOldAttendance addOldAttendance) {
          return attendanceService.AddOldAttendance(addOldAttendance);
      }
      @PatchMapping("/update")
      public String updateAttendance(@RequestBody AddOldAttendance addOldAttendance) {
          return attendanceService.updateAttendance(addOldAttendance);
      }
      

     
}