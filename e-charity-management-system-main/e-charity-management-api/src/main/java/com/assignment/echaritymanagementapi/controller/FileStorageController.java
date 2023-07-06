package com.assignment.echaritymanagementapi.controller;

import com.assignment.echaritymanagementapi.services.FileStorageService;
import com.assignment.echaritymanagementapi.services.model.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/file-storage")
public class FileStorageController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping(value = "/upload")
    public FileStorage saveFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        FileStorage fileStorage = fileStorageService.saveFile(file);

        return fileStorage;
    }

    @GetMapping(value = "/retrieve/{id}")
    public ResponseEntity<ByteArrayResource> retrieveFile(@PathVariable String id, Model model) throws IOException {
        FileStorage fileStorage = fileStorageService.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileStorage.getName() + "\"")
                .body(new ByteArrayResource(fileStorage.getContent().getData()));
    }

}
