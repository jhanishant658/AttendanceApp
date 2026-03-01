package com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Entities.Attendance;
import com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Repositories.AttendanceRepository;

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
        return "Attendance marked for user with ID: " + userId + " with status: " + status;
    }
    catch(Exception e){
        return "An error occurred while marking attendance: " + e.getMessage();
    }
    }
    public String getAllAttendace(long userId){
        try{
              return "attendance getted succesfully" ;
    }
    catch(Exception e){
        return "An error occurred while fetching attendance: " + e.getMessage();
    }
}
}
