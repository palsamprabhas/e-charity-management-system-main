import { Component, OnInit } from '@angular/core';
import { FundRaiseService } from 'src/app/services/fundraise.service';

@Component({
  selector: 'app-donations',
  templateUrl: './donations.component.html',
  styleUrls: ['./donations.component.css']
})
export class DonationsComponent implements OnInit {
  
  donations:any
  constructor(private fundRaiseService: FundRaiseService) { 
    this.getApprovedFundRaiseRequests()
  }

  ngOnInit(): void {
  }

  getApprovedFundRaiseRequests() {
    this.fundRaiseService.getFundRaiseRequestsByStatus('APPROVED').subscribe(
      (data) => {
        this.donations = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
