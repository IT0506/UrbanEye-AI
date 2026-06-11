package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.dto.AnalysisResponse;
import com.google.genai.Client;

@Service
public class GeminiService {

    @Value("${gemini.api-key}")
    private String apiKey;

    public AnalysisResponse analyzeIssue(String imageUrl) {

        AnalysisResponse response =
                new AnalysisResponse();

        if(imageUrl.contains("pothole")) {

            response.setIssueType("Pothole");
            response.setSeverity("High");

        } else if(imageUrl.contains("garbage")) {

            response.setIssueType("Garbage Dump");
            response.setSeverity("High");

        } else {

            response.setIssueType("Unknown");
            response.setSeverity("Low");
        }

        response.setComplaint(
            "Generated complaint for testing"
        );

        return response;
    }
}