import { Component, OnInit } from '@angular/core';
import { ApiService, GResponse } from '../api.service';
import { Router } from '@angular/router';


declare var google: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private api: ApiService, private router: Router) { }

  ngOnInit(): void {

    google.accounts.id.initialize({
      client_id: '833526689438-ulkroa81smqr629i2akgjvfuflnqrku1.apps.googleusercontent.com',
      callback: (res: any) => {
        this.api.loginUser(res).subscribe((resp: GResponse) => {
          alert(resp);
          this.router.navigate(['dashboard']);
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


  }

}
