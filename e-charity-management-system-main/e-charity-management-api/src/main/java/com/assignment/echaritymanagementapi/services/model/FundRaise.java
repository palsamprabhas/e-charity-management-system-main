package com.assignment.echaritymanagementapi.services.model;

import java.util.List;

public class FundRaise {
    private String id;
    private String requestedBy;
    private String subject;
    private String description;
    private Double amount;

    private Double collectedAmount;

    private List<String> donationPhotoIds;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(Double collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public List<String> getDonationPhotoIds() {
        return donationPhotoIds;
    }

    public void setDonationPhotoIds(List<String> donationPhotoIds) {
        this.donationPhotoIds = donationPhotoIds;
    }
}
