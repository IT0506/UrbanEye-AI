package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.FirestoreService;

@RestController
public class FirestoreController {

    @Autowired
    private FirestoreService firestoreService;

    @GetMapping("/firestore-test")
    public String test() throws Exception {

        return firestoreService.saveTestData();
    }
}