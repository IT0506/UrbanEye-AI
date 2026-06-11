package com.example.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import java.util.UUID;
@Service
public class StorageService {

    private final String bucketName =
            "urbaneye-ai.firebasestorage.app";

    public String uploadFile(MultipartFile file)
            throws Exception {

        Bucket bucket = StorageClient.getInstance().bucket();
        System.out.println("Bucket = " + bucket.getName());

        String fileName =
                UUID.randomUUID() + "_" +
                file.getOriginalFilename();

        Blob blob = bucket.create(
                fileName,
                file.getBytes(),
                file.getContentType());

        String downloadUrl =
        	    "https://firebasestorage.googleapis.com/v0/b/"
        	    + bucket.getName()
        	    + "/o/"
        	    + URLEncoder.encode(fileName, StandardCharsets.UTF_8)
        	    + "?alt=media";

        	return downloadUrl;
}
}
