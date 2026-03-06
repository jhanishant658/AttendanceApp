package com.attendenceApp.AttendanceApp.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.attendenceApp.AttendanceApp.Requests.AddOldAttendance;
import com.attendenceApp.AttendanceApp.Requests.AttendanceReq;
import com.attendenceApp.AttendanceApp.Requests.AttendanceRequest;
import com.attendenceApp.AttendanceApp.Requests.GetAttendanceByMonthRequest;
import com.attendenceApp.AttendanceApp.Response.AttendanceResponse;
import com.attendenceApp.AttendanceApp.Response.MonthlyAttendanceResponse;
import com.attendenceApp.AttendanceApp.Services.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
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
@PostMapping("/summary")
     public AttendanceResponse getAttendanceSummary(@RequestBody AttendanceReq req) {
        return attendanceService.getAttendanceSummary(req.getUserId());
     }
     @PostMapping("/addOldAttendance")
      public String addOldAttendance(@RequestBody AddOldAttendance addOldAttendance) {
          return attendanceService.AddOldAttendance(addOldAttendance);
      }
      @PatchMapping("/update")
      public String updateAttendance(@RequestBody AddOldAttendance addOldAttendance) {
          return attendanceService.updateAttendance(addOldAttendance);
      }
      @PostMapping("/byMonth")
      public MonthlyAttendanceResponse getMethodName(@RequestBody GetAttendanceByMonthRequest request) {
        long userId = request.getUserId();
        String param = request.getMonth() ;
          return attendanceService.getAllAttendanceByMonth(userId, param);
      }
      

     
}
