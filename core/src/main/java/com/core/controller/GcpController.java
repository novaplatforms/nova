package com.core.controller;

import com.core.service.gcp.IGoogleCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gcp")
public class GcpController {

    @Autowired
    private IGoogleCloudService googleCloudService;

    @PostMapping("/upload")
    public void uploadFile(String bucketName, String objectName, String filePath) {
        googleCloudService.uploadFile(bucketName, objectName, filePath);
    }

    @PostMapping("/download")
    public void downloadFile(String bucketName, String objectName, String downloadFilePath) {
        googleCloudService.downloadFile(bucketName, objectName, downloadFilePath);
    }

    @PostMapping("/delete")
    public void deleteFile(String bucketName, String objectName) {
        googleCloudService.deleteFile(bucketName, objectName);
    }
}
