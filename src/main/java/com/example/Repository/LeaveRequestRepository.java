package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {

}