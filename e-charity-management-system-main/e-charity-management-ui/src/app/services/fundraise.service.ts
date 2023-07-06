import { Subject, Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class FundRaiseService { 
    private fund_raise_endpoint: string = `http://localhost:8090/api/v1/fund-raise`;
    private create_fund_raise_endpoint: string = `http://localhost:8090/api/v1/fund-raise`;
    private update_user_status_endpoint: string = `http://localhost:8090/api/v1/fund-raise`;
    private get_all_users_by_status: string = `http://localhost:8090/api/v1/fund-raise/status`;

    constructor(private http: HttpClient) {}
   
    createFundRaise(data: any): Observable<any> {
      return this.http.post<any>(this.create_fund_raise_endpoint, data);
    }

    getFundRaiseRequestsByStatus(status:string): Observable<any> {
      return this.http.get<any>(this.get_all_users_by_status+'/'+status);
    }

    getNGOFundRaiseRequestsByStatus(ngoUsername:any, status:string): Observable<any> {
      return this.http.get<any>(this.fund_raise_endpoint+'/ngo/'+ngoUsername+'/status/'+status);
    }

    updateFundRaiseStatus(id:any, status:string): Observable<any> {
      return this.http.put<any>(this.update_user_status_endpoint+'/'+id+'/'+status, null);
    }

    updateFundRaisePhotos(data: any): Observable<any> {
      return this.http.put<any>(this.fund_raise_endpoint+'/photos', data);
    }
}