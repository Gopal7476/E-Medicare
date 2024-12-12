import { Component } from '@angular/core';
import { Medicines } from '../models/medicines.model';
import { MedicinesService } from '../services/medicines.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addmedicine',
  templateUrl: './addmedicine.component.html',
  styleUrls: ['./addmedicine.component.css']
})
export class AddmedicineComponent {

  medicine: Medicines = new Medicines();

  constructor(private medicinesService: MedicinesService, private router: Router) {}

  onAdd(): void {
    this.medicinesService.addMedicine(this.medicine).subscribe(() => {
      console.log('Medicine added:', this.medicine);
      this.router.navigate(['/adminhome']);
    })
  }

}
