package com.assignment.echaritymanagementapi.controller;

import com.assignment.echaritymanagementapi.services.DonationService;
import com.assignment.echaritymanagementapi.services.model.Donation;
import com.assignment.echaritymanagementapi.services.model.UserDonationResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class DonationControllerTest {

    @InjectMocks
    DonationController donationController;

    @Mock
    DonationService donationService;

    @Test
    void createDonation() {
        Donation donation = new Donation();

        when(donationService.createDonation(donation)).thenReturn(donation);

        Donation response = donationController.createDonation(donation);

        assertEquals(response, donation);
    }

    @Test
    void updateDonationStatus() {
        Donation donation = new Donation();

        when(donationService.updateDonationStatus("id", "SUCCESS")).thenReturn(donation);

        Donation response = donationController.updateDonationStatus("id", "SUCCESS");

        assertEquals(response, donation);
    }

    @Test
    void getAllDonations() {
        List<Donation> donations = mock(List.class);

        when(donationService.getAllDonations()).thenReturn(donations);

        List<Donation> response = donationController.getAllDonations();

        assertEquals(response, donations);
    }

    @Test
    void getAllUserDonations() {
        UserDonationResponse donation = new UserDonationResponse();
        List<UserDonationResponse> donations = new ArrayList<>();
        donations.add(donation);

        when(donationService.getAllUserDonations("username")).thenReturn(donations);

        List<UserDonationResponse> response = donationController.getAllUserDonations("username");

        assertEquals(response.size(), donations.size());
    }

    @Test
    void getAllDonationsByFundRequestId() {
        UserDonationResponse donation = new UserDonationResponse();
        List<UserDonationResponse> donations = new ArrayList<>();
        donations.add(donation);

        when(donationService.getAllDonationsByFundRequestId("id")).thenReturn(donations);

        List<UserDonationResponse> response = donationController.getAllDonationsByFundRequestId("id");

        assertEquals(response.size(), donations.size());
    }
}