package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.firestore.Firestore;

@RestController
public class TestController {

    @Autowired
    private Firestore firestore;

    @GetMapping("/firestore-status")
    public String status() {
        return firestore != null
                ? "Firestore Connected"
                : "Firestore Failed";
    }
}