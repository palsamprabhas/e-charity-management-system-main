import { Subject, Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class DonationService {
    private donation_endpoint: string = `http://localhost:8090/api/v1/donations`;   
    private get_user_donations_endpoint: string = `http://localhost:8090/api/v1/donations/user`; 

    constructor(private http: HttpClient) {}

    createDonation(data: any): Observable<any> {
      return this.http.post<any>(this.donation_endpoint, data);
    }  

    updateDonation(id:any, status:any): Observable<any> {
      return this.http.put<any>(this.donation_endpoint + '/' + id + '/' + status, null);
    }  

    getUserDonations(username: any): Observable<any> {
      return this.http.get<any>(this.get_user_donations_endpoint + '/'+ username);
    }

    getDonationsByFundRequestId(id: any): Observable<any> {
      return this.http.get<any>(this.donation_endpoint + '/fund-raise/'+ id);
    }

}