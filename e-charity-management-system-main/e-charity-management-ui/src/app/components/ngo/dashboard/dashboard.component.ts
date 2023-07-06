import { Component, OnInit } from '@angular/core';
import { FundRaiseService } from 'src/app/services/fundraise.service';
import {MatDialog} from '@angular/material/dialog';
import { DonarDetailsDialogComponent } from '../donar-details-dialog/donar-details-dialog.component';

@Component({
  selector: 'app-ngo-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class NGODashboardComponent implements OnInit {

  constructor(private fundRaiseService: FundRaiseService, public dialog: MatDialog) {
    this.getPenidngFundRaiseRequests();
    this.getApprvoedFundRaiseRequests();
   }

  ngOnInit(): void {
  }
  pendingFundRaiseRequests: any ;
  getPenidngFundRaiseRequests() {
    var ngoUsername = localStorage.getItem('username');
    this.fundRaiseService.getNGOFundRaiseRequestsByStatus(ngoUsername, 'PENDING').subscribe(
      (data) => {
        this.pendingFundRaiseRequests = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  approvedFundRaiseRequests: any ;
  getApprvoedFundRaiseRequests() {
    var ngoUsername = localStorage.getItem('username');
    this.fundRaiseService.getNGOFundRaiseRequestsByStatus(ngoUsername, 'APPROVED').subscribe(
      (data) => {
        this.approvedFundRaiseRequests = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  getDonarDetails() {
    const dialogRef = this.dialog.open(DonarDetailsDialogComponent);
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
