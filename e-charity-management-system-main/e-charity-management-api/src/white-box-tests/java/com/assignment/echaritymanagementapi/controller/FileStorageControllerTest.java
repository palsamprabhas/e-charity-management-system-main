package com.assignment.echaritymanagementapi.controller;

import com.assignment.echaritymanagementapi.services.FileStorageService;
import com.assignment.echaritymanagementapi.services.model.FileStorage;
import org.bson.types.Binary;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class FileStorageControllerTest {

    @InjectMocks
    FileStorageController fileStorageController;

    @Mock
    FileStorageService fileStorageService;

    @Test
    void saveFile() throws IOException {
        MultipartFile mockMultipartFile = mock(MultipartFile.class);
        FileStorage fileStorage = new FileStorage();

        when(fileStorageService.saveFile(mockMultipartFile)).thenReturn(fileStorage);

        FileStorage response = fileStorageController.saveFile(mockMultipartFile);

        assertEquals(response, fileStorage);
    }

    @Test
    void retrieveFile() throws IOException {
        FileStorage fileStorage = new FileStorage();
        fileStorage.setContent(new Binary("content".getBytes()));
        Model model = mock(Model.class);

        when(fileStorageService.getFile("id")).thenReturn(fileStorage);

        ResponseEntity<ByteArrayResource> response = fileStorageController.retrieveFile("id", model);

        assertNotNull(response);
    }
}