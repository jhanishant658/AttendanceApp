package com.attendenceApp.AttendanceApp.com.attendenceApp.AttendanceApp.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceResponse {
    private int presentCount;
    private int abbsentCount;
    private int totalAttendance;
    private double attendancePercentage;
    private int   daysRequiredFor75Percent;
    private int   daysRequiredFor60Percent;
    private int daysWeCanBeAbsentFor75Percent;
    private int daysWeCanBeAbsentFor60Percent;
    
}