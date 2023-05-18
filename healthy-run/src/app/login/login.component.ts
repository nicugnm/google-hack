import { Component } from '@angular/core';
import {NgForm} from "@angular/forms";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {AUTHENTICATE_URL} from "../constants/urls";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private httpClient: HttpClient,
              private router: Router) {
  }

  onSubmitLogin(form: NgForm): void {
    console.log('submit sent!');

    if (!form.valid) {
      return;
    }

    const email = form.value.email;
    const password = form.value.password;

    this.httpClient.post(AUTHENTICATE_URL, {'email': email, 'password': password})
      .subscribe((httpResponse: any) => {
        const token = httpResponse.token;
        localStorage.setItem('token', token);
        this.router.navigate(['/home']);
      });
  }

}
