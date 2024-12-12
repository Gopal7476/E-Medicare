import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { FormsModule } from '@angular/forms';
import { UsersService } from './services/users.service';
import { UserhomeComponent } from './userhome/userhome.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { UpdatemedicineComponent } from './updatemedicine/updatemedicine.component';
import { AddmedicineComponent } from './addmedicine/addmedicine.component';
import { MedicinesService } from './services/medicines.service';
import { CartitemsComponent } from './cartitems/cartitems.component';
import { CartItemsService } from './services/cartItems.service';
import { PaymentsComponent } from './payments/payments.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    UserhomeComponent,
    AdminhomeComponent,
    UpdatemedicineComponent,
    AddmedicineComponent,
    CartitemsComponent,
    PaymentsComponent,
    AboutusComponent,
    ContactusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [
    UsersService,
    MedicinesService,
    CartItemsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
