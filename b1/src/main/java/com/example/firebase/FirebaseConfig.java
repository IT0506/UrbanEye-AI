package com.example.firebase;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {

        System.out.println("===== FIREBASE CONFIG EXECUTED =====");

        GoogleCredentials credentials =
                GoogleCredentials.fromStream(
                        new ClassPathResource("serviceAccountKey.json")
                                .getInputStream());

        System.out.println("===== JSON FILE LOADED =====");

        FirebaseOptions options =
                FirebaseOptions.builder()
                        .setCredentials(credentials)
                        .setStorageBucket("urbaneye-ai.firebasestorage.app")
                        .build();
        if (FirebaseApp.getApps().isEmpty()) {

            System.out.println("===== INITIALIZING FIREBASE =====");

            FirebaseApp app = FirebaseApp.initializeApp(options);

            System.out.println("===== FIREBASE INITIALIZED =====");

            return app;
        }

        return FirebaseApp.getInstance();
    }
}