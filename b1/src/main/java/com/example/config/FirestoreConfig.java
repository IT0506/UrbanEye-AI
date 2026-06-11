package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;

@Configuration
public class FirestoreConfig {

		@Bean
		public Firestore firestore(FirebaseApp firebaseApp) {

		    System.out.println("CREATING FIRESTORE BEAN");

		    Firestore firestore =
		            FirestoreClient.getFirestore(firebaseApp);

		    System.out.println("FIRESTORE HASH = " + firestore.hashCode());

		    return firestore;
	}
}