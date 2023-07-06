package com.assignment.echaritymanagementapi.controller;

import com.assignment.echaritymanagementapi.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/payment-status")
    public List<Integer> getPaymentStatusReport() {
        return reportService.getPaymentStatusReport();
    }

    @GetMapping("/fund-raise-status")
    public List<Integer> getFundRaiseStatusReport() {
        return reportService.getFundRaiseStatusReport();
    }
}
