package com.example.controller;

import com.example.dto.ReportRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @PostMapping
    public String submitReport(
            @RequestBody ReportRequest request) {

        return "Report Received Successfully";
    }
}