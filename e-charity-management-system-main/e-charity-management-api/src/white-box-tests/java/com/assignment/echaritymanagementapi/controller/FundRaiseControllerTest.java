package com.assignment.echaritymanagementapi.controller;

import com.assignment.echaritymanagementapi.services.FundRaiseService;
import com.assignment.echaritymanagementapi.services.model.FundRaise;
import com.assignment.echaritymanagementapi.services.model.GeneralResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class FundRaiseControllerTest {

    @InjectMocks
    FundRaiseController fundRaiseController;

    @Mock
    FundRaiseService fundRaiseService;

    @Test
    void createFundRaiseRequest() {
        FundRaise fundRaise = new FundRaise();

        when(fundRaiseService.createFundRaiseRequest(fundRaise)).thenReturn(fundRaise);

        ResponseEntity<FundRaise> response = fundRaiseController.createFundRaiseRequest(fundRaise);

        assertEquals(response.getBody(), fundRaise);
    }

    @Test
    void getAllFundRaises() {
        List<FundRaise> fundRaises = mock(List.class);

        when(fundRaiseService.getAllFundRaises()).thenReturn(fundRaises);

        ResponseEntity<List<FundRaise>> response = fundRaiseController.getAllFundRaises();

        assertEquals(response.getBody(), fundRaises);
    }

    @Test
    void getAllFundRaisesByStatus() {
        List<FundRaise> fundRaises = mock(List.class);

        when(fundRaiseService.getAllFundRaisesByStatus("APPROVED")).thenReturn(fundRaises);

        ResponseEntity<List<FundRaise>> response = fundRaiseController.getAllFundRaisesByStatus("APPROVED");

        assertEquals(response.getBody(), fundRaises);
    }

    @Test
    void getAllNGOFundRaisesByStatus() {
        List<FundRaise> fundRaises = mock(List.class);

        when(fundRaiseService.getAllNGOFundRaisesByStatus("username", "APPROVED")).thenReturn(fundRaises);

        ResponseEntity<List<FundRaise>> response = fundRaiseController.getAllNGOFundRaisesByStatus("username", "APPROVED");

        assertEquals(response.getBody(), fundRaises);
    }

    @Test
    void updateFundRaiseRequestStatus() {
        GeneralResponse generalResponse = new GeneralResponse("updated successfully");

        when(fundRaiseService.updateFundRaiseRequestStatus("id", "APPROVED")).thenReturn(generalResponse);

        ResponseEntity<GeneralResponse> response = fundRaiseController.updateFundRaiseRequestStatus("id", "APPROVED");

        assertEquals(response.getBody(), generalResponse);
    }

    @Test
    void updateFundRaiseRequestPhotos() {
        FundRaise fundRaise = new FundRaise();

        GeneralResponse generalResponse = new GeneralResponse("updated successfully");

        when(fundRaiseService.updateFundRaiseRequestPhotos(fundRaise)).thenReturn(generalResponse);

        ResponseEntity<GeneralResponse> response = fundRaiseController.updateFundRaiseRequestPhotos(fundRaise);

        assertEquals(response.getBody(), generalResponse);
    }
}