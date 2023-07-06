package com.assignment.echaritymanagementapi.repository;

import com.assignment.echaritymanagementapi.services.model.Donation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends MongoRepository<Donation, String> {
    List<Donation> findAllByStatus(String status);

    List<Donation> findAllByDonorUserNameAndStatus(String donorUserName, String status);

    List<Donation> findAllByFundRequestIdAndStatus(String fundRequestId, String status);
}
