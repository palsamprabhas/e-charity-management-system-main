import { Component, OnInit } from '@angular/core';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'e-charity-management-ui';
  isCollapsed = true; 
  isLoggedIn = false;

  constructor(private userService: UserService) {

  }

  ngOnInit(): void {
    this.userService.updatemenu.subscribe(res => {
      this.isLoggedIn = true
    });
  }
}

