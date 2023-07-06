package com.assignment.echaritymanagementapi.controller;

import com.assignment.echaritymanagementapi.services.ReportService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReportControllerTest {
    @InjectMocks
    ReportController reportController;

    @Mock
    ReportService reportService;

    @Test
    void getPaymentStatusReport() {
        List<Integer> paymentStatusReport = new ArrayList<>();

        when(reportService.getPaymentStatusReport()).thenReturn(paymentStatusReport);

        List<Integer> response = reportController.getPaymentStatusReport();

        assertEquals(response, paymentStatusReport);
    }

    @Test
    void getFundRaiseStatusReport() {
        List<Integer> fundRaiseStatusReport = new ArrayList<>();

        when(reportService.getFundRaiseStatusReport()).thenReturn(fundRaiseStatusReport);

        List<Integer> response = reportController.getFundRaiseStatusReport();

        assertEquals(response, fundRaiseStatusReport);
    }
}