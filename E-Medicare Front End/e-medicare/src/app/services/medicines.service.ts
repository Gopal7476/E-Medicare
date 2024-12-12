import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Medicines } from "../models/medicines.model";

@Injectable ({
    providedIn: 'root'
})

export class MedicinesService {
    private baseUrl = 'http://localhost:9090/medicine';

    constructor(private http: HttpClient) {}

    getAllMedicines(): Observable<Medicines[]> {
        return this.http.get<Medicines[]>(`${this.baseUrl}`);
    }

    getMedicineById(medicineId: number): Observable<Medicines> {
        return this.http.get<Medicines>(`${this.baseUrl}/${medicineId}`);
    }

    addMedicine(medicine: Medicines): Observable<Medicines> {
        return this.http.post<Medicines>(`${this.baseUrl}`, medicine);
    }

    updateMedicine(medicineId: number, medicine: Medicines): Observable<Medicines> {
        return this.http.put<Medicines>(`${this.baseUrl}/update/${medicineId}`, medicine);
    }

    deleteMedicine(medicineId: number): Observable<Object> {
        return this.http.delete(`${this.baseUrl}/delete/${medicineId}`, { responseType: 'json' });
    }

}