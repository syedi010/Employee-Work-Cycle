package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

}