package com.assignment.echaritymanagementapi.controller;

import com.assignment.echaritymanagementapi.services.DonationService;
import com.assignment.echaritymanagementapi.services.model.Donation;
import com.assignment.echaritymanagementapi.services.model.UserDonationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public Donation createDonation(@RequestBody Donation donation) {
        return donationService.createDonation(donation);
    }

    @PutMapping("/{id}/{status}")
    public Donation updateDonationStatus(@PathVariable String id, @PathVariable String status) {
        return donationService.updateDonationStatus(id, status);
    }

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }

    @GetMapping("/user/{username}")
    public List<UserDonationResponse> getAllUserDonations(@PathVariable String username) {
        return donationService.getAllUserDonations(username);
    }

    @GetMapping("/fund-raise/{id}")
    public List<UserDonationResponse> getAllDonationsByFundRequestId(@PathVariable String id) {
        return donationService.getAllDonationsByFundRequestId(id);
    }
}
