package com.example.dto;

import lombok.Data;

@Data
public class ReportRequest {

    private String imageUrl;

    private Double latitude;

    private Double longitude;

}