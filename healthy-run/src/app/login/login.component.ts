import { Component } from '@angular/core';
import {User} from "../models/models";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  user: User = new User("", "")

  onSubmit(user: User) {
    const message: string = "User logged in successfully"
    console.log(message)
  }

}
