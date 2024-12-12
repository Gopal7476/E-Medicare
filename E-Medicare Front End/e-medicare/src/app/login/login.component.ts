import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UsersService } from '../services/users.service';
import { Users } from '../models/users.model';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  errorMessage = '';

  constructor(private userService: UsersService, private router: Router) {}

  onSubmit(loginForm: NgForm) {
    const { userName, userPassword } = loginForm.value;
    console.log(userName, userPassword);
    this.userService.login(userName, userPassword).subscribe(
      user => {
        if (userName === 'admin') {
          console.log('Admin Login successful!');
          this.router.navigate(['/adminhome']);
        } else {
          console.log('User Login successful!');
          this.router.navigate(['/userhome']);
        }
      },
      error => {
        console.error('Login failed', error);
        this.errorMessage = 'Invalid username or password';
      }
    );
  }

}
