import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { UpdatemedicineComponent } from './updatemedicine/updatemedicine.component';
import { AddmedicineComponent } from './addmedicine/addmedicine.component';
import { CartitemsComponent } from './cartitems/cartitems.component';
import { PaymentsComponent } from './payments/payments.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'signup', component: SignupComponent},
  { path: 'userhome', component: UserhomeComponent},
  { path: 'adminhome', component: AdminhomeComponent},
  { path: 'updatemedicine/:id', component: UpdatemedicineComponent},
  { path: 'addmedicine', component: AddmedicineComponent},
  { path: 'cartitems', component: CartitemsComponent},
  { path: 'payments', component: PaymentsComponent},
  { path: 'aboutus', component: AboutusComponent},
  { path: 'contactus', component: ContactusComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
