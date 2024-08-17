/*
 * @author Gnatyk Dmytro
 * This file is part of NOVA.
 *
 * NOVA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * NOVA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with NOVA. If not, see <https://www.gnu.org/licenses/>.
 */

package com.core.service.gcp;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class GoogleCloudService implements IGoogleCloudService {

    private final Logger logger = LoggerFactory.getLogger(GoogleCloudService.class);
    private final Storage storage = StorageOptions.getDefaultInstance().getService();

    @Override
    public void uploadFile(String bucketName, String objectName, String filePath) {
        try {
            logger.info("Uploading file to Google Cloud Storage");
            Bucket bucket = storage.get(bucketName);
            if (bucket == null) {
                throw new IllegalArgumentException("Bucket " + bucketName + " does not exist.");
            }
            byte[] content = Files.readAllBytes(Paths.get(filePath));
            bucket.create(objectName, content);
            logger.info("File uploaded successfully");
        } catch (IOException e) {
            logger.error("Failed to upload file: {}", e.getMessage());
        }
    }

    @Override
    public void downloadFile(String bucketName, String objectName, String downloadFilePath) {
        try {
            logger.info("Downloading file from Google Cloud Storage");
            Bucket bucket = storage.get(bucketName);
            if (bucket == null) {
                throw new IllegalArgumentException("Bucket " + bucketName + " does not exist.");
            }
            Blob blob = bucket.get(objectName);
            if (blob == null) {
                throw new IllegalArgumentException("Object " + objectName + " does not exist in bucket " + bucketName);
            }
            blob.downloadTo(Paths.get(downloadFilePath));
            logger.info("File downloaded successfully");
        } catch (Exception e) {
            logger.error("Failed to download file: {}", e.getMessage());
        }
    }

    @Override
    public void deleteFile(String bucketName, String objectName) {
        try {
            logger.info("Deleting file from Google Cloud Storage");
            Bucket bucket = storage.get(bucketName);
            if (bucket == null) {
                throw new IllegalArgumentException("Bucket " + bucketName + " does not exist.");
            }
            Blob blob = bucket.get(objectName);
            if (blob == null) {
                throw new IllegalArgumentException("Object " + objectName + " does not exist in bucket " + bucketName);
            }
            boolean deleted = blob.delete();
            if (deleted) {
                logger.info("File deleted successfully");
            } else {
                logger.warn("File could not be deleted");
            }
        } catch (Exception e) {
            logger.error("Failed to delete file: {}", e.getMessage());
        }
    }
}
