import { Subject, Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class ReportService {
    private report_endpoint: string = `http://localhost:8090/api/v1/reports`;   

    constructor(private http: HttpClient) {}
 

    getPaymentStatusReport(): Observable<any> {
      return this.http.get<any>(this.report_endpoint + '/payment-status');
    }

    getFundRaiseStatusReport(): Observable<any> {
      return this.http.get<any>(this.report_endpoint + '/fund-raise-status');
    }
}