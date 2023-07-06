import { Subject, Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
    providedIn: 'root'
})
export class FileStorageService {
    private upload_file_endpoint='http://localhost:8090/api/v1/file-storage/upload' 

    constructor(private http: HttpClient) {}
 
    saveFile(formData: FormData): Observable<any> {
      return this.http.post<any>(this.upload_file_endpoint, formData);  
    }

}