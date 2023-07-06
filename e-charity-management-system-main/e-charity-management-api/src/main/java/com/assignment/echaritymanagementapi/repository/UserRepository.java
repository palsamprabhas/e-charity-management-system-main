package com.assignment.echaritymanagementapi.repository;

import com.assignment.echaritymanagementapi.services.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsernameAndPasswordAndStatus(String id, String password, String status);

    List<User> findAllByStatus(String status);
}
