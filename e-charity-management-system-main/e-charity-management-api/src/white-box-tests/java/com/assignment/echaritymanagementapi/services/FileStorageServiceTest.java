package com.assignment.echaritymanagementapi.services;

import com.assignment.echaritymanagementapi.services.model.FileStorage;
import com.assignment.echaritymanagementapi.repository.FileStorageRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class FileStorageServiceTest {

    @Mock
    private FileStorageRepository fileStorageRepository;

    @InjectMocks
    private FileStorageService fileStorageService;

    @Test
    void testSaveFile() throws IOException {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("name", "data".getBytes());
        FileStorage fileStorage = mock(FileStorage.class);

        when(fileStorageRepository.save(any(FileStorage.class))).thenReturn(fileStorage);

        FileStorage response = fileStorageService.saveFile(mockMultipartFile);

        assertEquals(fileStorage, response);
    }

    @Test
    void testGetFile() {
        FileStorage fileStorage = mock(FileStorage.class);
        String id = "id";
        when(fileStorageRepository.findById(id)).thenReturn(Optional.of(fileStorage));

        FileStorage response = fileStorageService.getFile(id);

        assertEquals(fileStorage, response);
    }
}