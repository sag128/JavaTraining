package com.complaints.entity;

import java.time.LocalDate;

public class Complaints {

    private LocalDate dateReceived;
    private String product;
    private String subProduct;
    private String issue;
    private String subIssue;
    private String company;
    private String state;
    private String zipCode;
    private String submittedVia;
    private LocalDate closedDate;
    private String responseToCustomer;
    private boolean isTimelyResponse;
    private boolean isConsumerDisputed;
    private long complaintId;

    @Override
    public String toString() {
        return "Complaints{" +
                "dateReceived=" + dateReceived +
                ", product='" + product + '\'' +
                ", subProduct='" + subProduct + '\'' +
                ", issue='" + issue + '\'' +
                ", subIssue='" + subIssue + '\'' +
                ", company='" + company + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", submittedVia='" + submittedVia + '\'' +
                ", closedDate=" + closedDate +
                ", responseToCustomer='" + responseToCustomer + '\'' +
                ", isTimelyResponse=" + isTimelyResponse +
                ", isConsumerDisputed=" + isConsumerDisputed +
                ", complaintId=" + complaintId +
                '}';
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getSubIssue() {
        return subIssue;
    }

    public void setSubIssue(String subIssue) {
        this.subIssue = subIssue;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSubmittedVia() {
        return submittedVia;
    }

    public void setSubmittedVia(String submittedVia) {
        this.submittedVia = submittedVia;
    }

    public LocalDate getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDate closedDate) {
        this.closedDate = closedDate;
    }

    public String getResponseToCustomer() {
        return responseToCustomer;
    }

    public void setResponseToCustomer(String responseToCustomer) {
        this.responseToCustomer = responseToCustomer;
    }

    public boolean isTimelyResponse() {
        return isTimelyResponse;
    }

    public void setTimelyResponse(boolean timelyResponse) {
        isTimelyResponse = timelyResponse;
    }

    public boolean isConsumerDisputed() {
        return isConsumerDisputed;
    }

    public void setConsumerDisputed(boolean consumerDisputed) {
        isConsumerDisputed = consumerDisputed;
    }

    public long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(long complaintId) {
        this.complaintId = complaintId;
    }

    public Complaints(LocalDate dateReceived, String product, String subProduct, String issue, String subIssue, String company, String state, String zipCode, String submittedVia, LocalDate closedDate, String responseToCustomer, boolean isTimelyResponse, boolean isConsumerDisputed, long complaintId) {
        this.dateReceived = dateReceived;
        this.product = product;
        this.subProduct = subProduct;
        this.issue = issue;
        this.subIssue = subIssue;
        this.company = company;
        this.state = state;
        this.zipCode = zipCode;
        this.submittedVia = submittedVia;
        this.closedDate = closedDate;
        this.responseToCustomer = responseToCustomer;
        this.isTimelyResponse = isTimelyResponse;
        this.isConsumerDisputed = isConsumerDisputed;
        this.complaintId = complaintId;
    }





}
