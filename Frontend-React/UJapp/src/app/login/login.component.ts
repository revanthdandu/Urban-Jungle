import { Component, OnInit } from '@angular/core';
import { ApiService, UserLoginResponse } from '../api/api.service';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';


declare const google: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private api: ApiService, private router: Router) { }

  ngOnInit(): void {
    setTimeout(() => {
    
    
    google.accounts.id.initialize({
      client_id: environment.GCLIENT_ID,
      callback: (res: any) => {
        this.api.loginUser(res).subscribe((resp: UserLoginResponse) => {
          if(resp.loginStatus){
            alert(resp.loginStatus);
          this.router.navigate(['home']);
          }
        });
      }
    });


    google.accounts.id.renderButton(document.getElementById("google-btn"),{
      type: 'standard',
      theme: 'outline',
      size: 'large',
      text: 'signin_with',
      shape: 'pill',
      width: 'auto',
      logo_alignment: 'left'
    });

  }, 2000);

  }


}
