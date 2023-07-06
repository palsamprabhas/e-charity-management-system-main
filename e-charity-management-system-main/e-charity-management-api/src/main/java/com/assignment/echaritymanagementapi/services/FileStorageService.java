package com.assignment.echaritymanagementapi.services;


import com.assignment.echaritymanagementapi.repository.FileStorageRepository;
import com.assignment.echaritymanagementapi.services.model.FileStorage;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileStorageService {

    @Autowired
    private FileStorageRepository fileStorageRepository;

    public FileStorage saveFile(MultipartFile file) throws IOException {
        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(file.getOriginalFilename());
        fileStorage.setContent(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));

        return fileStorageRepository.save(fileStorage);
    }

    public FileStorage getFile(String id) {
        return fileStorageRepository.findById(id).get();
    }


}
