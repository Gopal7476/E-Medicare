import { Component, OnInit } from '@angular/core';
import { MedicinesService } from '../services/medicines.service';
import { Medicines } from '../models/medicines.model';
import { CartItemsService } from '../services/cartItems.service';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {
  medicines: Medicines[] = [];
  medicineTypes: string[] = [];
  searchText: string = '';
  selectedType: string = '';

  currentPage: number = 1;
  itemsPerPage: number = 5;
  totalPages: number = 1;

  constructor(private userService: UsersService, private medicinesService: MedicinesService, private cartItemsService: CartItemsService) { }

  ngOnInit(): void {
    this.loadMedicines();
  }

  loadMedicines(): void {
    this.medicinesService.getAllMedicines().subscribe(data => {
      this.medicines = data.filter(medicine => medicine.medicineAvailability === 'Available');
      this.updateMedicineTypes();
      this.calculateTotalPages(this.filteredMedicines().length);
    });
  }

  addToCart(medicine: Medicines): void {
    const userId = this.userService.getUserId();
    console.log(userId);
    this.cartItemsService.addToCart(medicine.medicineId, userId).subscribe(() => {
      console.log('Added to cart:', medicine);
    });
  }

  updateMedicineTypes(): void {
    this.medicineTypes = [...new Set(this.medicines.map(medicine => medicine.medicineType))].sort();
  }

  filteredMedicines(): Medicines[] {
    return this.medicines.filter(medicine => {
      const matchesName = medicine.medicineName.toLowerCase().includes(this.searchText.toLowerCase());
      const matchesType = this.selectedType ? medicine.medicineType === this.selectedType : true;
      return matchesName && matchesType;
    });
  }

  paginatedMedicines(): Medicines[] { 
    const filtered = this.filteredMedicines(); 
    const startIndex = (this.currentPage - 1) * this.itemsPerPage; 
    return filtered.slice(startIndex, startIndex + this.itemsPerPage); 
  } 
  
  calculateTotalPages(filteredLength: number): void { 
    this.totalPages = Math.ceil(filteredLength / this.itemsPerPage);
    console.log('Total Pages:', this.totalPages); 
  }
  
  nextPage(): void { 
    if (this.currentPage < this.totalPages) { 
      this.currentPage++;
      this.calculateTotalPages(this.filteredMedicines().length);
    } 
  } 
  
  previousPage(): void { 
    if (this.currentPage > 1) { 
      this.currentPage--;
      this.calculateTotalPages(this.filteredMedicines().length);
    } 
  }

}
