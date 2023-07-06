package com.assignment.echaritymanagementapi.services.model;

public class Donation {
    private String id;
    private String amount;
    private String message;

    private String fundRequestId;

    private String donorUserName;

    private String paymentOrderId;

    private String transactionId;

    private String paymentKey;

    private String email;

    private String phoneNumber;

    private String status;

    private String donationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFundRequestId() {
        return fundRequestId;
    }

    public void setFundRequestId(String fundRequestId) {
        this.fundRequestId = fundRequestId;
    }

    public String getDonorUserName() {
        return donorUserName;
    }

    public void setDonorUserName(String donorUserName) {
        this.donorUserName = donorUserName;
    }

    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    public void setPaymentOrderId(String paymentOrderId) {
        this.paymentOrderId = paymentOrderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public void setPaymentKey(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(String donationDate) {
        this.donationDate = donationDate;
    }
}
