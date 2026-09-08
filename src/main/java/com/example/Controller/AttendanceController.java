package com.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {
        @GetMapping("/attendance")
    public String getAttendance() {
        return "Attendance data";
    }
}
