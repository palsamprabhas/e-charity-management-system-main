package com.assignment.echaritymanagementapi.services;

import com.assignment.echaritymanagementapi.repository.DonationRepository;
import com.assignment.echaritymanagementapi.repository.FundRaiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private FundRaiseRepository fundRaiseRepository;

    public List<Integer> getPaymentStatusReport() {
        int successPaymentsCount = donationRepository.findAllByStatus("SUCCESS").size();
        int failedPaymentsCount = donationRepository.findAllByStatus("FAILED").size();
        int otherPaymentsCount = donationRepository.findAll().size() - successPaymentsCount - failedPaymentsCount;

        List<Integer> paymentStatusReport = new ArrayList<>();
        paymentStatusReport.add(successPaymentsCount);
        paymentStatusReport.add(failedPaymentsCount);
        paymentStatusReport.add(otherPaymentsCount);

        return paymentStatusReport;
    }

    public List<Integer> getFundRaiseStatusReport() {
        int approvedFundRaiseCount = fundRaiseRepository.findAllByStatus("APPROVED").size();
        int rejectedFundRaiseCount = fundRaiseRepository.findAllByStatus("REJECTED").size();
        int otherFundRaiseCount = fundRaiseRepository.findAll().size() - approvedFundRaiseCount - rejectedFundRaiseCount;

        List<Integer> paymentStatusReport = new ArrayList<>();
        paymentStatusReport.add(approvedFundRaiseCount);
        paymentStatusReport.add(rejectedFundRaiseCount);
        paymentStatusReport.add(otherFundRaiseCount);

        return paymentStatusReport;
    }
}
