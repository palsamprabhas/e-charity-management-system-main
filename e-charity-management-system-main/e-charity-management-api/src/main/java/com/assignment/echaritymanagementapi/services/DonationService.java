package com.assignment.echaritymanagementapi.services;

import com.assignment.echaritymanagementapi.config.RazopayConfig;
import com.assignment.echaritymanagementapi.repository.DonationRepository;
import com.assignment.echaritymanagementapi.repository.FundRaiseRepository;
import com.assignment.echaritymanagementapi.repository.UserRepository;
import com.assignment.echaritymanagementapi.services.model.Donation;
import com.assignment.echaritymanagementapi.services.model.FundRaise;
import com.assignment.echaritymanagementapi.services.model.User;
import com.assignment.echaritymanagementapi.services.model.UserDonationResponse;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DonationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DonationRepository donationRepository;
    @Autowired
    private FundRaiseRepository fundRaiseRepository;
    @Autowired
    private RazopayConfig razopayConfig;
    private RazorpayClient razorpayClient;

    public Donation createDonation(Donation donation) {
        try {
            User user = userRepository.findById(donation.getDonorUserName()).get();
            razorpayClient = new RazorpayClient(razopayConfig.getKey(), razopayConfig.getSecret());

            BigDecimal bigDecimal = new BigDecimal(donation.getAmount());
            BigDecimal value = bigDecimal.multiply(new BigDecimal("100"));
            String amount = value.setScale(0, RoundingMode.UP).toString();
            String transactionID = UUID.randomUUID().toString();

            JSONObject options = new JSONObject();
            options.put("amount", amount);
            options.put("currency", "INR");
            options.put("receipt", transactionID);

            Order order = razorpayClient.orders.create(options);

            donation.setPaymentOrderId(order.get("id"));
            donation.setTransactionId(transactionID);
            donation.setPaymentKey(razopayConfig.getKey());
            donation.setEmail(user.getEmail());
            donation.setPhoneNumber(user.getPhoneNumber());
            donation.setStatus("INITIATED");

            donation = donationRepository.save(donation);

        } catch (Exception exception) {
            donation.setStatus("FAILED");
        }
        return donation;
    }

    public Donation updateDonationStatus(String donationId, String status) {
        Donation donation = donationRepository.findById(donationId).get();
        donation.setStatus(status);
        if ("SUCCESS".equalsIgnoreCase(status)) {
            FundRaise fundRaise = fundRaiseRepository.findById(donation.getFundRequestId()).get();
            fundRaise.setCollectedAmount(fundRaise.getCollectedAmount() + Double.valueOf(donation.getAmount()));
            Date date = new Date();
            SimpleDateFormat DateFor = new SimpleDateFormat("dd-MM-yyyy");
            donation.setDonationDate(DateFor.format(date));
            fundRaiseRepository.save(fundRaise);
        }
        return donationRepository.save(donation);
    }

    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    public List<UserDonationResponse> getAllUserDonations(String username) {
        List<Donation> donations = donationRepository.findAllByDonorUserNameAndStatus(username, "SUCCESS");
        List<UserDonationResponse> userDonationResponses = new ArrayList<>();
        for (Donation donation : donations) {
            UserDonationResponse userDonationResponse = new UserDonationResponse();
            userDonationResponse.setDonation(donation);
            FundRaise fundRaise = fundRaiseRepository.findById(donation.getFundRequestId()).get();
            userDonationResponse.setDonationRequestBy(userRepository.findById(fundRaise.getRequestedBy()).get());
            userDonationResponse.setFundRaise(fundRaise);
            userDonationResponses.add(userDonationResponse);
        }

        return userDonationResponses;
    }

    public List<UserDonationResponse> getAllDonationsByFundRequestId(String id) {
        List<Donation> donations = donationRepository.findAllByFundRequestIdAndStatus(id, "SUCCESS");
        List<UserDonationResponse> userDonationResponses = new ArrayList<>();
        for (Donation donation : donations) {
            UserDonationResponse userDonationResponse = new UserDonationResponse();
            userDonationResponse.setDonation(donation);
            FundRaise fundRaise = fundRaiseRepository.findById(donation.getFundRequestId()).get();
            userDonationResponse.setDonationRequestBy(userRepository.findById(fundRaise.getRequestedBy()).get());
            userDonationResponse.setFundRaise(fundRaise);
            userDonationResponses.add(userDonationResponse);
        }

        return userDonationResponses;
    }
}
