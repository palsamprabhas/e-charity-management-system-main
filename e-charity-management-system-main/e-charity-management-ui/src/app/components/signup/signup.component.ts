import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { FileStorageService } from 'src/app/services/filestorage.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  donorUserForm: FormGroup;
  ngoUserForm: FormGroup;
  constructor(private router: Router, private userService:UserService, private fileStorageService:FileStorageService, private matSnackBar: MatSnackBar) {
    this.donorUserForm = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.minLength(8)]),
      password: new FormControl('', [Validators.required]),
      confirmPassword: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),      
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('[- +()0-9]+')]),
      address: new FormControl('', [Validators.required]),     
    });
    this.ngoUserForm = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.minLength(8)]),
      password: new FormControl('', [Validators.required]),
      confirmPassword: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),     
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('[- +()0-9]+')]),
      address: new FormControl('', [Validators.required]),     
      ngoType: new FormControl('', [Validators.required]),  
      ngoShortDescription: new FormControl('', [Validators.required]),  
    });  
   }

  ngOnInit(): void {
  }

  selectedRoleOption: string = 'DONOR';
  
  isDonorFormSubmitted = false;
  isNGOFormSubmitted = false;

  createDonorUserDetails() {        
    this.isDonorFormSubmitted = true;
    if (this.donorUserForm.valid) {        
      this.donorUserForm.value['role'] = 'DONOR';       
      this.fileStorageService.saveFile(this.formData).subscribe(
        data => {           
          this.donorUserForm.value['profilePicFileId'] = data.id;                          
          this.userService.createUser(this.donorUserForm.value).subscribe(
            (data) => {
              this.router.navigateByUrl('login')
              let snackBarRef = this.matSnackBar.open(
                'Registered successfully, please sign with your name and passowrd', 
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
        },
        (error) => {
          console.log(error);
        }
      )                                        
    }  
  }

  createNGOUserDetails() {    
    this.isNGOFormSubmitted = true;
    if (this.ngoUserForm.valid) {        
      this.ngoUserForm.value['role'] = 'NGO';
      this.fileStorageService.saveFile(this.formData).subscribe(
        data => {           
          this.donorUserForm.value['profilePicFileId'] = data.id;                          
          this.userService.createUser(this.ngoUserForm.value).subscribe(
            (data) => {
              this.router.navigateByUrl('login')
              let snackBarRef = this.matSnackBar.open(
                'Registered successfully, please wait for your request to approve.', 
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
        },
        (error) => {
          console.log(error);
        }
      )                                               
    } 
  }

  formData = new FormData();
  addProfilePhoto(file:any) {         
      this.formData.append( "file", file.target.files[0], file.target.files[0]['name'] );
  }
 
}
