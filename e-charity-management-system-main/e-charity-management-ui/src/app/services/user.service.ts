import { Subject, Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class UserService {
    private login_endpoint: string = `http://localhost:8090/api/v1/user/login`;
    private create_user_endpoint: string = `http://localhost:8090/api/v1/user`;
    private update_user_endpoint: string = `http://localhost:8090/api/v1/user`;
    private get_user_endpoint: string = `http://localhost:8090/api/v1/user`;
    private update_user_status_endpoint: string = `http://localhost:8090/api/v1/user`;
    private get_all_users_by_status: string = `http://localhost:8090/api/v1/user/status`;

    constructor(private http: HttpClient) {}

    private _updatemenu = new Subject<void>();
    get updatemenu() {
      return this._updatemenu;
    }

    login(data: any): Observable<any> {
      return this.http.post<any>(this.login_endpoint, data);
    }

    createUser(data: any): Observable<any> {
      return this.http.post<any>(this.create_user_endpoint, data);
    }

    getUserByUsername(username:string): Observable<any> {
      return this.http.get<any>(this.get_user_endpoint+'/'+username);
    }

    getUsersByStatus(status:string): Observable<any> {
      return this.http.get<any>(this.get_all_users_by_status+'/'+status);
    }

    updateUserStatus(username:any, status:string): Observable<any> {
      return this.http.put<any>(this.update_user_status_endpoint+'/'+username+'/'+status, null);
    }

    upateUser(data:any): Observable<any> {
      return this.http.put<any>(this.update_user_endpoint,data);
    }
}