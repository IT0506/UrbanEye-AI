package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Issue;

@Service
public class ReportService {

    public String generateReport(
            Issue issue) {

        return """
                MUNICIPAL REPORT

                Issue Type:
                %s

                Severity:
                %s

                Complaint:
                %s
                """
                .formatted(
                        issue.getIssueType(),
                        issue.getSeverity(),
                        issue.getComplaint());
    }
}
