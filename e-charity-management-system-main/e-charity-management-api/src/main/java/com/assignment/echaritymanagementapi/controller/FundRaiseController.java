package com.assignment.echaritymanagementapi.controller;

import com.assignment.echaritymanagementapi.services.FundRaiseService;
import com.assignment.echaritymanagementapi.services.model.FundRaise;
import com.assignment.echaritymanagementapi.services.model.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fund-raise")
public class FundRaiseController {

    @Autowired
    private FundRaiseService fundRaiseService;

    @PostMapping
    public ResponseEntity<FundRaise> createFundRaiseRequest(@RequestBody FundRaise fundRaise) {
        FundRaise response = fundRaiseService.createFundRaiseRequest(fundRaise);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<List<FundRaise>> getAllFundRaises() {
        List<FundRaise> response = fundRaiseService.getAllFundRaises();

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<FundRaise>> getAllFundRaisesByStatus(@PathVariable String status) {
        List<FundRaise> response = fundRaiseService.getAllFundRaisesByStatus(status);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

    @GetMapping("/ngo/{username}/status/{status}")
    public ResponseEntity<List<FundRaise>> getAllNGOFundRaisesByStatus(@PathVariable String username, @PathVariable String status) {
        List<FundRaise> response = fundRaiseService.getAllNGOFundRaisesByStatus(username, status);

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity<GeneralResponse> updateFundRaiseRequestStatus(@PathVariable String id, @PathVariable String status) {
        GeneralResponse generalResponse = fundRaiseService.updateFundRaiseRequestStatus(id, status);
        return new ResponseEntity(
                generalResponse,
                HttpStatus.OK
        );

    }

    @PutMapping("/photos")
    public ResponseEntity<GeneralResponse> updateFundRaiseRequestPhotos(@RequestBody FundRaise fundRaise) {
        GeneralResponse generalResponse = fundRaiseService.updateFundRaiseRequestPhotos(fundRaise);
        return new ResponseEntity(
                generalResponse,
                HttpStatus.OK
        );

    }
}
