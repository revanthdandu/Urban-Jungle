import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }



  public loginUser(data: any): Observable<UserLoginResponse> {
    const httpHeaders = new HttpHeaders({
      Authorization: 'Bearer ' + data.credential
    });
    return this.http.post<UserLoginResponse>('http://localhost:8080/auth/login', data,{headers: httpHeaders});
  }
}

export interface GResponse {
  clientId: String,
  client_id: String,
  credential: String,
  select_by: String
}

export interface UserLoginResponse{
  fullname: String,
  loginStatus: String
}
