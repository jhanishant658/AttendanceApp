package com.attendenceApp.AttendanceApp.Requests;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOldAttendance {

    private Long userId;
    private String date;
    private String status;

    
}