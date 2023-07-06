package com.assignment.echaritymanagementapi.model;

import com.assignment.echaritymanagementapi.services.model.FundRaise;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FundRaiseTest {

    @Test
    public void testFundRaise() {
        FundRaise fundRaise = new FundRaise();
        fundRaise.setId("id");
        fundRaise.setStatus("REJECTED");
        fundRaise.setCollectedAmount(2000d);
        fundRaise.setAmount(10000d);
        fundRaise.setDescription("description");
        fundRaise.setSubject("subject");
        fundRaise.setRequestedBy("testuser");
        List<String> donationPhotos =new ArrayList<>();
        donationPhotos.add("photo-01");
        donationPhotos.add("photo-02");
        fundRaise.setDonationPhotoIds(donationPhotos);

        assertEquals("id", fundRaise.getId());
        assertEquals("REJECTED", fundRaise.getStatus());
        assertEquals(2000d, fundRaise.getCollectedAmount());
        assertEquals(10000d, fundRaise.getAmount());
        assertEquals("description", fundRaise.getDescription());
        assertEquals("subject", fundRaise.getSubject());
        assertEquals("testuser", fundRaise.getRequestedBy());
        assertEquals(donationPhotos, fundRaise.getDonationPhotoIds());
    }

}