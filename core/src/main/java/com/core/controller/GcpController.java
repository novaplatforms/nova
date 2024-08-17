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
