import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  userForm: FormGroup;
  constructor(private userService: UserService) {
    this.userForm = new FormGroup({           
      name: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),      
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('[- +()0-9]+')]),
      address: new FormControl('', [Validators.required]),           
    }); 
    this.getUser()
   }

  ngOnInit(): void {
  }

  isFormSubmitted = false;

  getUser() {
    var username = localStorage.getItem('username')
    if (username != null) {
      this.userService.getUserByUsername(username).subscribe(
        (data) => {           
          this.userForm.controls["name"].setValue(data.name);
          this.userForm.controls["email"].setValue(data.email);
          this.userForm.controls["phoneNumber"].setValue(data.phoneNumber);          
        },
        (error) => {
          console.log(error);
        }
      );
    } 
  }

  upateUser() {
    var username = localStorage.getItem('username')
    if (username != null) {
      var data = {username: username, name: this.userForm.value['name'], email: this.userForm.value['email'], phoneNumber: this.userForm.value['phoneNumber']}
      this.userService.upateUser(data).subscribe(
        (data) => {        
        },
        (error) => {
          console.log(error);
        }
      );
    } 
  }
}
