import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: any;
  userProfilePicUrl = ''
  isAdmin = false;
  isNgo = false;
  isDonor = false;

  constructor(private userService: UserService, private router: Router) { 
    this.getUserDetails()
  }

  ngOnInit(): void {
    var role = localStorage.getItem("role");
    if(role == "ADMIN") {
      this.isAdmin = true;
    } else if(role == "DONOR"){
      this.isDonor = true;
    } else if(role == "NGO"){
      this.isNgo = true;
    }
  }

  getUserDetails() {
    var username = localStorage.getItem('username')
    if (username != null) {
      this.userService.getUserByUsername(username).subscribe(
        (data) => {
          this.user = data;      
          this.userProfilePicUrl = "http://localhost:8090/api/v1/file-storage/retrieve/" + data.profilePicFileId
        },
        (error) => {
          console.log(error);
        }
      );
    } 
  }

  logout() {   
    localStorage.clear()
    this.router.navigateByUrl('/login')
  }
  
}
