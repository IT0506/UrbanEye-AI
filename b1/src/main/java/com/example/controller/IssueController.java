package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.AnalysisResponse;
import com.example.entity.Issue;
import com.example.service.GeminiService;
import com.example.service.IssueService;
import com.example.service.StorageService;

@RestController
@RequestMapping("/api/issues")
@CrossOrigin(origins = "http://localhost:5173")
public class IssueController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private IssueService issueService;

    @GetMapping("/save")
    public String saveIssue() throws Exception {

        Issue issue = new Issue();

        issue.setIssueType("Pothole");
        issue.setDescription("Large pothole near bus stop");

        return issueService.saveIssue(issue);
    }

    @PostMapping("/upload")
    public String upload(
            @RequestParam("file") MultipartFile file)
            throws Exception {

        return storageService.uploadFile(file);
    }

    @PostMapping("/analyze")
    public AnalysisResponse analyze(
            @RequestParam String imageUrl) {

        return geminiService.analyzeIssue(imageUrl);
    }

    @PostMapping("/upload-analyze")
    public AnalysisResponse uploadAnalyze(
            @RequestParam("file") MultipartFile file)
            throws Exception {

        // Upload image
        String imageUrl =
                storageService.uploadFile(file);

        // Analyze image
        AnalysisResponse response =
                geminiService.analyzeIssue(imageUrl);

        // Save in Firestore
        Issue issue = new Issue();

        issue.setImageUrl(imageUrl);
        issue.setIssueType(response.getIssueType());
        issue.setSeverity(response.getSeverity());
        issue.setComplaint(response.getComplaint());

        issueService.saveIssue(issue);

        return response;
    }
}