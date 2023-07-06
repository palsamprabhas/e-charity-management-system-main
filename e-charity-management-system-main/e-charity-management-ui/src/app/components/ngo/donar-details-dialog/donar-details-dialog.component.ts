import { Component, OnInit, Inject } from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DonationService } from 'src/app/services/donations.service';

@Component({
  selector: 'app-donar-details-dialog',
  templateUrl: './donar-details-dialog.component.html',
  styleUrls: ['./donar-details-dialog.component.css']
})
export class DonarDetailsDialogComponent implements OnInit {

  donationDetails:any
  constructor(@Inject(MAT_DIALOG_DATA) public data: {id: string}, private donationService:DonationService) { 
    donationService.getDonationsByFundRequestId(data.id).subscribe(
      (data) => {
        this.donationDetails = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  ngOnInit(): void {
  }

}
