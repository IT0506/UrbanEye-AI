package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.Firestore;

@Service
public class FirestoreService {

    @Autowired
    private Firestore firestore;

    public String saveTestData() throws Exception {

        Map<String,Object> data =
                new HashMap<>();

        data.put("message", "Firestore Connected");

        firestore.collection("test")
                .document("demo")
                .set(data)
                .get();

        return "Saved Successfully";
    }
}