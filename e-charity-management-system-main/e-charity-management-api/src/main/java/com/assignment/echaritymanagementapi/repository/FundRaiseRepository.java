package com.assignment.echaritymanagementapi.repository;

import com.assignment.echaritymanagementapi.services.model.FundRaise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundRaiseRepository extends MongoRepository<FundRaise, String> {
    List<FundRaise> findAllByStatus(String status);

    List<FundRaise> findAllByRequestedByAndStatus(String requestedBy, String status);
}
