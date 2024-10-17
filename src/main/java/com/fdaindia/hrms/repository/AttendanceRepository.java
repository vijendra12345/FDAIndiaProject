package com.fdaindia.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdaindia.hrms.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
