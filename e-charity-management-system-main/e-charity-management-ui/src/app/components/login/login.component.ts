import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userForm: FormGroup;
  constructor(private router: Router, private userService:UserService) {
    this.userForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    }); 
   }

  ngOnInit(): void {
  }
  isUserFormSubmitted = false;
  login() {
    this.isUserFormSubmitted = true
    if (this.userForm.valid) {
      this.userService.login(this.userForm.value).subscribe(
        (data) => {     
            localStorage.setItem("username", data.username);
            this.userService.updatemenu.next()
            if (data.role == "ADMIN") {
              localStorage.setItem("role", "ADMIN");
              this.router.navigateByUrl('admin-dashboard')
            }
            if (data.role == "DONOR") {
              localStorage.setItem("role", "DONOR");
              this.router.navigateByUrl('donation-requests')
            }
            if (data.role == "NGO") {     
              localStorage.setItem("role", "NGO"); 
              this.router.navigateByUrl('ngo-dashboard')
            }
        },
        (error) => {
          console.log(error);
        }
      );
    }   
  }
}
