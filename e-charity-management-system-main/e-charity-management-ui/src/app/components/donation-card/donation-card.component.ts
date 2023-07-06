import { Component, OnInit, Input, HostListener } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DonationService } from 'src/app/services/donations.service';

declare var Razorpay: any;

@Component({
  selector: 'app-donation-card',
  templateUrl: './donation-card.component.html',
  styleUrls: ['./donation-card.component.css']
})
export class DonationCardComponent implements OnInit {

  progressPercentage:any;
  progressStyle:any;
  progressClass: any;
  @Input() donatonRequest : any
  donationPhoto = ''

  donationAmountForm: FormGroup;
  constructor(private donationService: DonationService) {   
    this.donationAmountForm = new FormGroup({
      amount: new FormControl('', [Validators.required]),
      message: new FormControl('', [Validators.required]),      
    });  
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
    this.donationPhoto = "http://localhost:8090/api/v1/file-storage/retrieve/" + this.donatonRequest['donationPhotoIds'][0]         
  }

  options = {
      "key": "",
      "amount": "", 
      "name": "e-charity management",
      "description": "Web Development",      
      "order_id":"",
      "handler": function (response:any){       
          var event = new CustomEvent("payment.success", 
              {
                  detail: response,
                  bubbles: true,
                  cancelable: true
              }
          );    
          window.dispatchEvent(event);
      }
      ,
      "prefill": {
      "name": "",
      "email": "",
      "contact": ""
      },
      "notes": {
      "address": ""
      },
      "theme": {
      "color": "#9c3353"
      }
    };

  donationId: any
  donate(fundRequestId: any) {      
    var requestData = {
        "donorUserName": localStorage.getItem("username"),
        "fundRequestId": fundRequestId,
        "message": this.donationAmountForm.value['message'],
        "amount": this.donationAmountForm.value['amount']
    }    
    this.donationService.createDonation(requestData).subscribe(
      (data) => {          
            this.donationId=data.id;                 
            this.options.key = data.paymentKey;
            this.options.order_id = data.paymentOrderId;
            this.options.amount = data.amount; //paise
            this.options.prefill.name =requestData.donorUserName!;
            this.options.prefill.email = data.email;
            this.options.prefill.contact = data.phoneNumber;
            var razopay = new Razorpay(this.options);
            razopay.open();
                       
            razopay.on('payment.failed', function (response:any){ 
              var event = new CustomEvent("payment.failed", 
                  {
                      detail: response,
                      bubbles: true,
                      cancelable: true
                  }
              );                                              
             }
            );
      },
      (error) => {
        console.log(error);
      }
    );  
  }  

  @HostListener('window:payment.success', ['$event']) 
  onPaymentSuccess(event:any): void {
      this.updateDonationStatus(this.donationId, "SUCCESS")      
  }

  @HostListener('window:payment.failed', ['$event']) 
  onPaymentFailed(event:any): void {
      this.updateDonationStatus(this.donationId, "FAILED")
  }

  updateDonationStatus(id:any, status: any) {
    this.donationService.updateDonation(id, status).subscribe(       
      );
  }

  showCollectAmountForm = false;
  toggleShowCollectAmountForm(): void {
    this.showCollectAmountForm = !this.showCollectAmountForm;
  }
}
