package com.attendenceApp.AttendanceApp.Response;

import java.util.List;

import com.attendenceApp.AttendanceApp.Requests.MonthlyResReq;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyAttendanceResponse {

   private int month ; 
   private int year ;
   private List<MonthlyResReq> attendances ;
    
}