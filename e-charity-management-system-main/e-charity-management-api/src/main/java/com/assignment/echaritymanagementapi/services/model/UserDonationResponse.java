package com.assignment.echaritymanagementapi.services.model;

public class UserDonationResponse {
    private Donation donation;
    private FundRaise fundRaise;

    private User donationRequestBy;

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public FundRaise getFundRaise() {
        return fundRaise;
    }

    public void setFundRaise(FundRaise fundRaise) {
        this.fundRaise = fundRaise;
    }

    public User getDonationRequestBy() {
        return donationRequestBy;
    }

    public void setDonationRequestBy(User donationRequestBy) {
        this.donationRequestBy = donationRequestBy;
    }
}
