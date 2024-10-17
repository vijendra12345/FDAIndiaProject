package com.fdaindia.hrms.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fdaindia.hrms.entity.Attendance;
import com.fdaindia.hrms.repository.AttendanceRepository;
import com.fdaindia.hrms.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }
}
