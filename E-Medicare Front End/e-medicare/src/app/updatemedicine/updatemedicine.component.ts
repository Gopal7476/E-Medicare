import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MedicinesService } from '../services/medicines.service';
import { Medicines } from '../models/medicines.model';

@Component({
  selector: 'app-updatemedicine',
  templateUrl: './updatemedicine.component.html',
  styleUrls: ['./updatemedicine.component.css']
})
export class UpdatemedicineComponent implements OnInit {
  medicine: Medicines = new Medicines();

  constructor(
    private route: ActivatedRoute,
    private medicinesService: MedicinesService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const medicineId = this.route.snapshot.paramMap.get('id');
    this.medicinesService.getMedicineById(Number(medicineId)).subscribe(data => {
      this.medicine = data;
    });
  }

  onUpdate(): void {
    this.medicinesService.updateMedicine(this.medicine.medicineId, this.medicine).subscribe(() => {
      console.log('Medicine updated:', this.medicine);
      this.router.navigate(['/adminhome']);
    });
  }
}
