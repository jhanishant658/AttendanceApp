package com.attendenceApp.AttendanceApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendenceApp.AttendanceApp.Entities.Attendance;
import com.attendenceApp.AttendanceApp.Repositories.AttendanceRepository;
import com.attendenceApp.AttendanceApp.Requests.AttendanceRequest;
import com.attendenceApp.AttendanceApp.Requests.AddOldAttendance;
import com.attendenceApp.AttendanceApp.Response.AttendanceResponse;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository ;
    
    public String markAttendance(AttendanceRequest attendanceRequest) {
        // Implement attendance marking logic here
        try{
            long userId = attendanceRequest.getUserId();
            String status = attendanceRequest.getStatus();
            if(attendanceRepository.existsByUserIdAndDate(userId, java.time.LocalDate.now().toString())) {
                return "Attendance already marked for today" ;
            }
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
    public String updateAttendance(AddOldAttendance attendance) {
        // Implement attendance update logic here
        Long userId = attendance.getUserId();
        String date = attendance.getDate();
        String status = attendance.getStatus();
        try{
        Attendance attendances =  attendanceRepository.findByUserIdAndDate(userId, date) ;
        if(attendances == null) {
            return "Attendance record not found" ;
        }
        attendances.setStatus(status);
        attendanceRepository.save(attendances);
        return "Attendance updated successfully" ;
    }
    catch(Exception e){
        return "An error occurred while updating attendance: " + e.getMessage();
    }
    }
    public String AddOldAttendance(AddOldAttendance addOldAttendance) {
        Long userId = addOldAttendance.getUserId();
        String date = addOldAttendance.getDate();
        String status = addOldAttendance.getStatus();
        // Implement logic to add old attendance record here
        try{
        if(attendanceRepository.existsByUserIdAndDate(userId, date)) {
            return "Attendance record already exists for the given date" ;
        }
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
