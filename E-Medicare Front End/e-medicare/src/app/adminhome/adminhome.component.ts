import { Component, OnInit } from '@angular/core';
import { MedicinesService } from '../services/medicines.service';
import { Medicines } from '../models/medicines.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  medicines: Medicines[] = [];

  constructor(private medicinesService: MedicinesService, private router: Router) {}

  ngOnInit(): void {
    this.medicinesService.getAllMedicines().subscribe(data => {
      this.medicines = data;
    });
  }

  updateMedicine(medicine: Medicines): void {
    console.log('Updating medicine:', medicine);
    this.router.navigate(['/updatemedicine', medicine.medicineId]);
  }

  deleteMedicine(medicineId: number): void {
    this.medicinesService.deleteMedicine(medicineId).subscribe(() => {
      console.log('Medicine deleted:', medicineId);
      this.medicines = this.medicines.filter(m => m.medicineId !== medicineId);
    });
  }

}
