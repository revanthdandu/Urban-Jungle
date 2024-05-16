import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }


  public loginUser(data: any): Observable<GResponse> {
    return this.http.post<GResponse>('http://localhost:8080/auth/login', data);
  }



}

export interface GResponse {
  clientId: String,
  client_id: String,
  credentials: String,
  select_by: String
}