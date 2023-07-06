package com.assignment.echaritymanagementapi.services;


import com.assignment.echaritymanagementapi.repository.FundRaiseRepository;
import com.assignment.echaritymanagementapi.services.model.FundRaise;
import com.assignment.echaritymanagementapi.services.model.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FundRaiseService {

    @Autowired
    private FundRaiseRepository fundRaiseRepository;

    public FundRaise createFundRaiseRequest(FundRaise fundRaise) {
        fundRaise.setStatus("PENDING");
        fundRaise.setCollectedAmount(0d);
        return fundRaiseRepository.save(fundRaise);
    }

    public List<FundRaise> getAllFundRaises() {
        return fundRaiseRepository.findAll();
    }

    public List<FundRaise> getAllFundRaisesByStatus(String status) {
        return fundRaiseRepository.findAllByStatus(status);
    }

    public List<FundRaise> getAllNGOFundRaisesByStatus(String username, String status) {
        return fundRaiseRepository.findAllByRequestedByAndStatus(username, status);
    }

    public GeneralResponse updateFundRaiseRequestStatus(String id, String status) {
        Optional<FundRaise> optionalFundRaise = fundRaiseRepository.findById(id);
        if (!optionalFundRaise.isPresent()) {
            return new GeneralResponse("fund raise request could not found");
        }
        FundRaise fundRaise = optionalFundRaise.get();
        fundRaise.setStatus(status);
        fundRaiseRepository.save(fundRaise);
        return new GeneralResponse("updated status successfully");
    }

    public GeneralResponse updateFundRaiseRequestPhotos(FundRaise fundRaiseRequest) {
        Optional<FundRaise> optionalFundRaise = fundRaiseRepository.findById(fundRaiseRequest.getId());
        if (!optionalFundRaise.isPresent()) {
            return new GeneralResponse("fund raise request could not found");
        }
        FundRaise fundRaise = optionalFundRaise.get();
        fundRaise.setDonationPhotoIds(fundRaiseRequest.getDonationPhotoIds());
        fundRaiseRepository.save(fundRaise);
        return new GeneralResponse("updated photos successfully");
    }
}
