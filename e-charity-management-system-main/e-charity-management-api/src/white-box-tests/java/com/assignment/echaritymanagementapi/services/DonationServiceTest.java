package com.assignment.echaritymanagementapi.services;

import com.assignment.echaritymanagementapi.config.RazopayConfig;
import com.assignment.echaritymanagementapi.services.model.Donation;
import com.assignment.echaritymanagementapi.services.model.FundRaise;
import com.assignment.echaritymanagementapi.services.model.User;
import com.assignment.echaritymanagementapi.services.model.UserDonationResponse;
import com.assignment.echaritymanagementapi.repository.DonationRepository;
import com.assignment.echaritymanagementapi.repository.FundRaiseRepository;
import com.assignment.echaritymanagementapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class DonationServiceTest {

    @InjectMocks
    private DonationService donationService;

    @Mock
    private DonationRepository donationRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private FundRaiseRepository fundRaiseRepository;
    @Mock
    private RazopayConfig razopayConfig;

    @Test
    void testCreateDonation() {
        Donation donation = new Donation();
        donation.setDonorUserName("testuser");
        donation.setAmount("1000");
        User user = new User();

        when(userRepository.findById("testuser")).thenReturn(Optional.of(user));
        when(razopayConfig.getKey()).thenReturn("key");
        when(razopayConfig.getSecret()).thenReturn("secret");
        when(donationRepository.save(donation)).thenReturn(donation);

        Donation response = donationService.createDonation(donation);

        assertEquals(donation, response);
    }

    @Test
    void testUpdateDonationStatus() {
        String donationId = "id";
        String status = "SUCCESS";
        Donation donation = new Donation();
        donation.setFundRequestId("fund-request-id");
        donation.setAmount("20000");
        FundRaise fundRaise = new FundRaise();
        fundRaise.setCollectedAmount(1000d);

        when(donationRepository.findById(donationId)).thenReturn(Optional.of(donation));
        when(fundRaiseRepository.findById("fund-request-id")).thenReturn(Optional.of(fundRaise));
        when(fundRaiseRepository.save(fundRaise)).thenReturn(fundRaise);
        when(donationRepository.save(donation)).thenReturn(donation);

        Donation response = donationService.updateDonationStatus(donationId, status);

        assertEquals(response, donation);
    }

    @Test
    void testGetAllDonations() {
        List<Donation> donations = mock(List.class);
        when(donationRepository.findAll()).thenReturn(donations);

        List<Donation> response = donationService.getAllDonations();

        assertEquals(response, donations);
    }

    @Test
    void testGetAllUserDonations() {
        Donation donation = new Donation();
        donation.setFundRequestId("fundid");
        List<Donation> donations = new ArrayList<>();
        donations.add(donation);
        FundRaise fundRaise = new FundRaise();
        fundRaise.setRequestedBy("request-id");
        User user = new User();

        when( donationRepository.findAllByDonorUserNameAndStatus("user", "SUCCESS")).thenReturn(donations);
        when( fundRaiseRepository.findById(donation.getFundRequestId())).thenReturn(Optional.of(fundRaise));
        when( userRepository.findById(fundRaise.getRequestedBy())).thenReturn(Optional.of(user));

        List<UserDonationResponse> response = donationService.getAllUserDonations("user");

        assertEquals(response.size(), 1);
    }

    @Test
    void testGetAllDonationsByFundRequestId() {
        Donation donation = new Donation();
        donation.setFundRequestId("fundid");
        List<Donation> donations = new ArrayList<>();
        donations.add(donation);
        FundRaise fundRaise = new FundRaise();
        fundRaise.setRequestedBy("request-id");
        User user = new User();

        when( donationRepository.findAllByFundRequestIdAndStatus("requestid", "SUCCESS")).thenReturn(donations);
        when( fundRaiseRepository.findById(donation.getFundRequestId())).thenReturn(Optional.of(fundRaise));
        when( userRepository.findById(fundRaise.getRequestedBy())).thenReturn(Optional.of(user));

        List<UserDonationResponse> response = donationService.getAllDonationsByFundRequestId("requestid");

        assertEquals(response.size(), 1);
    }
}