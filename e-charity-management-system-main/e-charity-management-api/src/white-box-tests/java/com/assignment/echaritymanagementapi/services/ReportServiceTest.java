package com.assignment.echaritymanagementapi.services;

import com.assignment.echaritymanagementapi.services.model.Donation;
import com.assignment.echaritymanagementapi.services.model.FundRaise;
import com.assignment.echaritymanagementapi.repository.DonationRepository;
import com.assignment.echaritymanagementapi.repository.FundRaiseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReportServiceTest {

    @InjectMocks
    ReportService reportService;

    @Mock
    DonationRepository donationRepository;

    @Mock
    FundRaiseRepository fundRaiseRepository;

    @Test
    void getPaymentStatusReport() {
        Donation donation1 = new Donation();
        Donation donation2 = new Donation();
        Donation donation3 = new Donation();
        Donation donation4 = new Donation();
        List<Donation> successDonations = new ArrayList<>();
        successDonations.add(donation1);
        successDonations.add(donation2);
        List<Donation> failedDonations = new ArrayList<>();
        failedDonations.add(donation3);

        List<Donation> allDonations = new ArrayList<>();
        allDonations.add(donation1);
        allDonations.add(donation2);
        allDonations.add(donation3);
        allDonations.add(donation4);

        when(donationRepository.findAllByStatus("SUCCESS")).thenReturn(successDonations);
        when(donationRepository.findAllByStatus("FAILED")).thenReturn(failedDonations);
        when(donationRepository.findAll()).thenReturn(allDonations);

        List<Integer> response = reportService.getPaymentStatusReport();

        assertEquals(3, response.size());
        assertEquals(2, response.get(0));
        assertEquals(1, response.get(1));
        assertEquals(1, response.get(2));
    }

    @Test
    void getFundRaiseStatusReport() {
        FundRaise fundRaise1 = new FundRaise();
        FundRaise fundRaise2 = new FundRaise();
        FundRaise fundRaise3 = new FundRaise();
        FundRaise fundRaise4 = new FundRaise();
        List<FundRaise> approvedFundRaiseRequests = new ArrayList<>();
        approvedFundRaiseRequests.add(fundRaise1);
        approvedFundRaiseRequests.add(fundRaise2);
        List<FundRaise> rejectedFundRaiseRequests = new ArrayList<>();
        rejectedFundRaiseRequests.add(fundRaise3);

        List<FundRaise> allFundRaiseRequests = new ArrayList<>();
        allFundRaiseRequests.add(fundRaise1);
        allFundRaiseRequests.add(fundRaise2);
        allFundRaiseRequests.add(fundRaise3);
        allFundRaiseRequests.add(fundRaise4);

        when(fundRaiseRepository.findAllByStatus("APPROVED")).thenReturn(approvedFundRaiseRequests);
        when(fundRaiseRepository.findAllByStatus("REJECTED")).thenReturn(rejectedFundRaiseRequests);
        when(fundRaiseRepository.findAll()).thenReturn(allFundRaiseRequests);

        List<Integer> response = reportService.getFundRaiseStatusReport();

        assertEquals(3, response.size());
        assertEquals(2, response.get(0));
        assertEquals(1, response.get(1));
        assertEquals(1, response.get(2));
    }
}