package com.example.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Issue;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class IssueService {

    @Autowired
    private Firestore firestore;

    public String saveIssue(Issue issue) throws Exception {

        Firestore db = FirestoreClient.getFirestore();

        String id = UUID.randomUUID().toString();

        issue.setId(id);

        db.collection("issues")
          .document(id)
          .set(issue);

        return id;
    }
}