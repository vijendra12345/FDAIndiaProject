package com.fdaindia.hrms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fdaindia.hrms.entity.Attendance;
import com.fdaindia.hrms.request.PunchRequest;
import com.fdaindia.hrms.service.AttendanceService;

import java.util.Date;

@RestController
@RequestMapping("/attendance/emp")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @PostMapping("/punch")
    public ResponseEntity<String> punch(
            @RequestParam Long employeeId,
            @RequestParam String action,
            @RequestParam double latitude,
            @RequestParam double longitude) {
        
        Attendance attendance = new Attendance();
        attendance.setEmployeeId(employeeId);
        attendance.setTimestamp(new Date());
        attendance.setAction(action);
        attendance.setLatitude(latitude);
        attendance.setLongitude(longitude);

        attendanceService.saveAttendance(attendance);

        return ResponseEntity.ok("Punch " + action + " recorded successfully.");
    }
}
