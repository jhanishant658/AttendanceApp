package com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Entities.Attendance;
import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Repositories.AttendanceRepository;
import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Response.AttendanceResponse;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository ;
    
    public String markAttendance(Long userId , String status) {
        // Implement attendance marking logic here
        try{
        Attendance attendance = new Attendance();
        attendance.setUserId(userId);
        attendance.setStatus(status);
        attendance.setDate(java.time.LocalDate.now().toString());
        attendanceRepository.save(attendance);
        return "Attendance marked successfully" ;
    }
    catch(Exception e){
        return "An error occurred while marking attendance: " + e.getMessage();
    }
    }
    public AttendanceResponse getAttendanceSummary(Long userId) {
        // Implement attendance summary logic here
        int presentCount = attendanceRepository.countByUserIdAndStatus(userId, "present");
        int abbsentCount = attendanceRepository.countByUserIdAndStatus(userId, "absent");
        int totalAttendance = presentCount + abbsentCount;
        double attendancePercentage = totalAttendance > 0 ? (presentCount * 100.0) / totalAttendance : 0.0 ; 
        int daysRequiredFor75Percent 
        , daysRequiredFor60Percent  ,  daysWeCanBeAbsentFor60Percent , daysWeCanBeAbsentFor75Percent ;
        if(attendancePercentage < 60) {
            // Logic to calculate how many more days of attendance are needed to reach 75%
            daysRequiredFor75Percent = (int) Math.ceil((0.75 * totalAttendance - presentCount) / 0.25);
         daysRequiredFor60Percent = (int) Math.ceil((0.60 * totalAttendance - presentCount) / 0.40);
        daysWeCanBeAbsentFor75Percent = 0 ; 
        daysWeCanBeAbsentFor60Percent =0 ; 
        }
        else if(attendancePercentage >= 60 && attendancePercentage < 75) {

    daysRequiredFor75Percent =
        (int) Math.ceil((0.75 * totalAttendance - presentCount) / 0.25);

    daysRequiredFor60Percent = 0;

    daysWeCanBeAbsentFor75Percent = 0;

    daysWeCanBeAbsentFor60Percent =
        Math.max(0,
            (int) Math.floor((presentCount - 0.60 * totalAttendance) / 0.60)
        );
}
else {

    daysRequiredFor75Percent = 0;
    daysRequiredFor60Percent = 0;

    daysWeCanBeAbsentFor75Percent =
        Math.max(0,
            (int) Math.floor((presentCount - 0.75 * totalAttendance) / 0.75)
        );

    daysWeCanBeAbsentFor60Percent =
        Math.max(0,
            (int) Math.floor((presentCount - 0.60 * totalAttendance) / 0.60)
        );
}
        return new AttendanceResponse(presentCount, abbsentCount, totalAttendance, attendancePercentage, daysRequiredFor75Percent, daysRequiredFor60Percent, daysWeCanBeAbsentFor75Percent, daysWeCanBeAbsentFor60Percent);
    }
    public String updateAttendance(Long attendanceId , String status) {
        // Implement attendance update logic here
        try{
        Attendance attendance = attendanceRepository.findById(attendanceId).orElse(null);
        if(attendance == null) {
            return "Attendance record not found" ;
        }
        attendance.setStatus(status);
        attendanceRepository.save(attendance);
        return "Attendance updated successfully" ;
    }
    catch(Exception e){
        return "An error occurred while updating attendance: " + e.getMessage();
    }
    }
    public String AddOldAttendance(Long userId , String date , String status) {
        // Implement logic to add old attendance record here
        try{
        Attendance attendance = new Attendance();
        attendance.setUserId(userId);
        attendance.setStatus(status);
        attendance.setDate(date);
        attendanceRepository.save(attendance);
        return "Old attendance record added successfully" ;
    }
    catch(Exception e){
        return "An error occurred while adding old attendance record: " + e.getMessage();
    }
    }
}
