import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsersService } from '../services/users.service';
import { Users } from '../models/users.model';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  newUser: Users = new Users();
  showSuccessMessage = false;
  @ViewChild('signupForm') signupForm!: NgForm;

  constructor(private usersService: UsersService) {}

  onSubmit(form: NgForm) {
    if (!form.valid) return;

    this.newUser = { ...form.value };

    console.log(this.newUser);

    this.usersService.addUser(this.newUser).subscribe(
      () => {
        this.showSuccessMessage = true;
        setTimeout(() => {
          this.showSuccessMessage = false;
          form.resetForm();
        }, 3000);
      },
      error => {
        console.log('Signup failed', error);
      }
    );    
  }
}
