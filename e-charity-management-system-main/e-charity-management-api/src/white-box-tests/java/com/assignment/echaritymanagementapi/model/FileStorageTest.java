package com.assignment.echaritymanagementapi.model;

import com.assignment.echaritymanagementapi.services.model.FileStorage;
import org.bson.types.Binary;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileStorageTest {

    @Test
    public void testFileStorage() {
        FileStorage fileStorage = new FileStorage();
        fileStorage.setId("id");
        fileStorage.setName("name");
        fileStorage.setContent(new Binary("content".getBytes()));

        assertEquals("id", fileStorage.getId());
        assertEquals("name", fileStorage.getName());
        assertEquals(new Binary("content".getBytes()), fileStorage.getContent());
    }

}