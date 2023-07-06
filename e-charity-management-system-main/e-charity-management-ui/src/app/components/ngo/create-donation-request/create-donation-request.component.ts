import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { FileStorageService } from 'src/app/services/filestorage.service';
import { FundRaiseService } from 'src/app/services/fundraise.service';

@Component({
  selector: 'app-create-donation-request',
  templateUrl: './create-donation-request.component.html',
  styleUrls: ['./create-donation-request.component.css']
})
export class CreateDonationRequestComponent implements OnInit {

  raiseFundFormGroup: FormGroup;
  constructor(private router: Router, private fundRaiseService:FundRaiseService, private fileStorageService: FileStorageService, private matSnackBar: MatSnackBar) { 
    this.raiseFundFormGroup = new FormGroup({
      subject: new FormControl('', [Validators.required, Validators.minLength(8)]),
      description: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),     
      amount: new FormControl('', [Validators.required, Validators.pattern('[0-9]+')]),     
    });
  }

  ngOnInit(): void {
  }

  isFundRaiseFormSubmitted = false;

  createFundRaise() {        
    this.isFundRaiseFormSubmitted = true;
    if (this.raiseFundFormGroup.valid) {        
      var username = localStorage.getItem('username');
      this.raiseFundFormGroup.value['requestedBy'] = username; 
      var donationPhotoIds = new Array<any>();                        
      this.raiseFundFormGroup.value['donationPhotoIds'] = donationPhotoIds;                         
      this.fundRaiseService.createFundRaise(this.raiseFundFormGroup.value).subscribe(
        (data) => {  
          var fundRaiseId = data.id;
          for (var i = 0; i < this.formDataArray.length; i++) {              
            this.fileStorageService.saveFile(this.formDataArray[i]).subscribe(
              data => {           
                donationPhotoIds.push(data.id);      
                if(this.formDataArray.length == donationPhotoIds.length) {
                  var updateFundRaisePhotosRequestData = {"id": fundRaiseId, "donationPhotoIds": donationPhotoIds}
                  this.fundRaiseService.updateFundRaisePhotos(updateFundRaisePhotosRequestData).subscribe(
                    data => {           
                      console.log(data);                                    
                    },
                    (error) => {
                      console.log(error);
                    }
                  );
                }                                        
              },
              (error) => {                
                console.log(error);
              }
            ) 
          }                              
          this.router.navigateByUrl('create-donation')
          let snackBarRef = this.matSnackBar.open(
            'Your fund raise request registered successfully', 
            'Dismiss',
            {
              duration: 8000, 
              horizontalPosition: 'center',
              verticalPosition: 'top',
            }
          );
        },
        (error) => {
          console.log(error);
        }
      );        
    }  else{      
    }
  }

  formDataArray = new Array<FormData>();
  addDonationPhotos(file:any) {       
    var filesLength = file.target.files.length;
    for (var i = 0; i < filesLength; i++) {      
        var formData = new FormData()
        formData.append( "file", file.target.files[i], file.target.files[i]['name'] );
        this.formDataArray.push(formData)
    }       
  }

}
