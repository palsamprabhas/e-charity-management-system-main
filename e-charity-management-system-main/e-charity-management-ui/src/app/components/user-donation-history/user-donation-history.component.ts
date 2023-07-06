import { Component, OnInit } from '@angular/core';
import { DonationService } from 'src/app/services/donations.service';

@Component({
  selector: 'app-user-donation-history',
  templateUrl: './user-donation-history.component.html',
  styleUrls: ['./user-donation-history.component.css']
})
export class UserDonationHistoryComponent implements OnInit {

  constructor(private donationService: DonationService) { 
    this.getUserDonations();
  }

  ngOnInit(): void {
  }

  userDonations: any

  getUserDonations() {
    var username = localStorage.getItem('username');
    this.donationService.getUserDonations(username).subscribe(
      (data) => {
        this.userDonations = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
