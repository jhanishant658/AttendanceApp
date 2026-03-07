package com.attendenceApp.AttendanceApp.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class percentageIfAttendNextDaysRequest {
    long userId ;
    int nextDays ;
}
