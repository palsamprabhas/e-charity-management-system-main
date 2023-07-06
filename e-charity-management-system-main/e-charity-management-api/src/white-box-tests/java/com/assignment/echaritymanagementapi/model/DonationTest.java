package com.assignment.echaritymanagementapi.model;

import com.assignment.echaritymanagementapi.services.model.Donation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DonationTest {

    @Test
    public void testDonation() {
        Donation donation = new Donation();
        donation.setId("id");
        donation.setDonationDate("01-10-2022");
        donation.setStatus("SUCCESS");
        donation.setEmail("test@gmail.com");
        donation.setPhoneNumber("9874562134");
        donation.setPaymentKey("payment-key");
        donation.setTransactionId("transaction-id");
        donation.setPaymentOrderId("payment-order-id");
        donation.setAmount("1000");
        donation.setFundRequestId("fund-request-id");
        donation.setMessage("test-message");
        donation.setDonorUserName("donor-user-name");

        Assertions.assertEquals("id", donation.getId());
        Assertions.assertEquals("01-10-2022", donation.getDonationDate());
        Assertions.assertEquals("SUCCESS", donation.getStatus());
        Assertions.assertEquals("test@gmail.com", donation.getEmail());
        Assertions.assertEquals("9874562134", donation.getPhoneNumber());
        Assertions.assertEquals("payment-key", donation.getPaymentKey());
        Assertions.assertEquals("transaction-id", donation.getTransactionId());
        Assertions.assertEquals("payment-order-id", donation.getPaymentOrderId());
        Assertions.assertEquals("1000", donation.getAmount());
        Assertions.assertEquals("fund-request-id", donation.getFundRequestId());
        Assertions.assertEquals("test-message", donation.getMessage());
        Assertions.assertEquals("donor-user-name", donation.getDonorUserName());
    }

}