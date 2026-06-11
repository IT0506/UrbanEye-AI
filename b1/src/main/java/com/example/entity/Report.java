package com.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Report {

    private String reportId;

    private String issueType;

    private String severity;

    private String department;

    private String imageUrl;

    private Double latitude;

    private Double longitude;

    private String complaint;

    private String status;

}