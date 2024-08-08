package com.core.service.gcp;

import org.springframework.stereotype.Service;

@Service
public interface IGoogleCloudService {
    void uploadFile(String bucketName, String objectName, String filePath);
    void downloadFile(String bucketName, String objectName, String downloadFilePath);
    void deleteFile(String bucketName, String objectName);
}
