import { Component, OnInit } from '@angular/core';
import { FundRaiseService } from 'src/app/services/fundraise.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {

  constructor(private userService: UserService, private fundRaiseService: FundRaiseService) { }

  peningNgoUsers: any ;
  pendingFundRaiseRequests: any ;
  ngOnInit(): void {
    this.getPenidngNGOUsers()
    this.getPenidngFundRaiseRequests()
  }

  getPenidngNGOUsers() {
    this.userService.getUsersByStatus('PENDING').subscribe(
      (data) => {
        this.peningNgoUsers = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  getPenidngFundRaiseRequests() {
    this.fundRaiseService.getFundRaiseRequestsByStatus('PENDING').subscribe(
      (data) => {
        this.pendingFundRaiseRequests = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  updateUserStatus(username:any, requestStatus: any) {
    this.userService.updateUserStatus(username, requestStatus).subscribe(
      (data) => {
        this.getPenidngNGOUsers()
      },
      (error) => {
        console.log(error);
      }
    );
  }

  updateFundRaiseRequest(id:any, requestStatus: any) {
    this.fundRaiseService.updateFundRaiseStatus(id, requestStatus).subscribe(
      (data) => {
        this.getPenidngFundRaiseRequests()
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
