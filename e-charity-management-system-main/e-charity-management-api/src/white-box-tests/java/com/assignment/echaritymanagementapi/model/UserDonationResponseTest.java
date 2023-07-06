package com.assignment.echaritymanagementapi.model;

import com.assignment.echaritymanagementapi.services.model.Donation;
import com.assignment.echaritymanagementapi.services.model.FundRaise;
import com.assignment.echaritymanagementapi.services.model.User;
import com.assignment.echaritymanagementapi.services.model.UserDonationResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDonationResponseTest {

    @Test
   public void testUserDonationResponse() {
        UserDonationResponse userDonationResponse = new UserDonationResponse();
        User user = new User();
        Donation donation = new Donation();
        FundRaise fundRaise = new FundRaise();

        userDonationResponse.setDonationRequestBy(user);
        userDonationResponse.setDonation(donation);
        userDonationResponse.setFundRaise(fundRaise);

        assertEquals(user, userDonationResponse.getDonationRequestBy());
        assertEquals(donation, userDonationResponse.getDonation());
        assertEquals(fundRaise, userDonationResponse.getFundRaise());
    }

}