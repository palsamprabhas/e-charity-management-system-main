package com.assignment.echaritymanagementapi.repository;

import com.assignment.echaritymanagementapi.services.model.FileStorage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStorageRepository extends MongoRepository<FileStorage, String> {

}