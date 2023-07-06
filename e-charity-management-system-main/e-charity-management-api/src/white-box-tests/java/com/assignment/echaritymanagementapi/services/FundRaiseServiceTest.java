package com.assignment.echaritymanagementapi.services;

import com.assignment.echaritymanagementapi.services.model.FundRaise;
import com.assignment.echaritymanagementapi.services.model.GeneralResponse;
import com.assignment.echaritymanagementapi.repository.FundRaiseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class FundRaiseServiceTest {

    @InjectMocks
    FundRaiseService fundRaiseService;

    @Mock
    FundRaiseRepository fundRaiseRepository;

    @Test
    void createFundRaiseRequest() {
        FundRaise fundRaise = new FundRaise();

        when(fundRaiseRepository.save(fundRaise)).thenReturn(fundRaise);

        FundRaise response = fundRaiseService.createFundRaiseRequest(fundRaise);

        assertEquals(response, fundRaise);
    }

    @Test
    void getAllFundRaises() {
        List<FundRaise> fundRaises = mock(List.class);

        when(fundRaiseRepository.findAll()).thenReturn(fundRaises);

        List<FundRaise> response = fundRaiseService.getAllFundRaises();

        assertEquals(response, fundRaises);
    }

    @Test
    void getAllFundRaisesByStatus() {
        List<FundRaise> fundRaises = mock(List.class);

        when(fundRaiseRepository.findAllByStatus("SUCCESS")).thenReturn(fundRaises);

        List<FundRaise> response = fundRaiseService.getAllFundRaisesByStatus("SUCCESS");

        assertEquals(response, fundRaises);
    }

    @Test
    void getAllNGOFundRaisesByStatus() {
        List<FundRaise> fundRaises = mock(List.class);

        when(fundRaiseRepository.findAllByRequestedByAndStatus("username", "SUCCESS")).thenReturn(fundRaises);

        List<FundRaise> response = fundRaiseService.getAllNGOFundRaisesByStatus("username", "SUCCESS");

        assertEquals(response, fundRaises);
    }

    @Test
    void updateFundRaiseRequestStatus() {
        FundRaise fundRaise = new FundRaise();

        when(fundRaiseRepository.findById("id")).thenReturn(Optional.of(fundRaise));
        when(fundRaiseRepository.save(fundRaise)).thenReturn(fundRaise);

        GeneralResponse generalResponse = fundRaiseService.updateFundRaiseRequestStatus("id", "SUCCESS");

        assertNotNull(generalResponse);
        assertEquals(generalResponse.getMessage(), "updated status successfully");
    }

    @Test
    void updateFundRaiseRequestStatusWhenFundNotFound() {
        FundRaise fundRaise = new FundRaise();

        when(fundRaiseRepository.findById("id")).thenReturn(Optional.empty());

        GeneralResponse generalResponse = fundRaiseService.updateFundRaiseRequestStatus("id", "SUCCESS");

        assertNotNull(generalResponse);
        assertEquals(generalResponse.getMessage(), "fund raise request could not found");
    }

    @Test
    void updateFundRaiseRequestPhotos() {
        FundRaise fundRaise = new FundRaise();
        fundRaise.setId("id");

        when(fundRaiseRepository.findById("id")).thenReturn(Optional.of(fundRaise));
        when(fundRaiseRepository.save(fundRaise)).thenReturn(fundRaise);

        GeneralResponse generalResponse = fundRaiseService.updateFundRaiseRequestPhotos(fundRaise);

        assertNotNull(generalResponse);
        assertEquals(generalResponse.getMessage(), "updated photos successfully");
    }

    @Test
    void updateFundRaiseRequestPhotosWhenFundNotFound() {
        FundRaise fundRaise = new FundRaise();
        fundRaise.setId("id");

        when(fundRaiseRepository.findById("id")).thenReturn(Optional.empty());

        GeneralResponse generalResponse = fundRaiseService.updateFundRaiseRequestPhotos(fundRaise);

        assertNotNull(generalResponse);
        assertEquals(generalResponse.getMessage(), "fund raise request could not found");
    }
}