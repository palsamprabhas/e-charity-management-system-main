import { Component, OnInit, Input, HostListener } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { DonationService } from 'src/app/services/donations.service';
import { DonarDetailsDialogComponent } from '../donar-details-dialog/donar-details-dialog.component';

declare var Razorpay: any;

@Component({
  selector: 'app-ngo-donation-card',
  templateUrl: './ngo-donation-card.component.html',
  styleUrls: ['./ngo-donation-card.component.css']
})
export class NGODonationCardComponent implements OnInit {

  progressPercentage:any;
  progressStyle:any;
  progressClass: any;
  @Input() donatonRequest : any

  constructor(public dialog: MatDialog) {   
 
  }

  ngOnInit(): void {    
    this.progressPercentage = (this.donatonRequest['collectedAmount']/this.donatonRequest['amount'])*100;   
    this.progressStyle = "width: " + this.progressPercentage + "%"
    if(this.progressPercentage < 40) {
      this.progressClass = "progress-bar progress-bar-striped bg-danger";
    } else if(this.progressPercentage < 90) {
      this.progressClass = "progress-bar progress-bar-striped bg-warning";
    } else {
      this.progressClass = "progress-bar progress-bar-striped bg-success";
    }
      
  }
 
  getDonarDetails(id:any) {    
    const dialogRef = this.dialog.open(DonarDetailsDialogComponent, {
      data: { id: id },
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
