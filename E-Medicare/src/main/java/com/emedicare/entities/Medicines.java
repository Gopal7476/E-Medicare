package com.emedicare.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicinesDetails")
public class Medicines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicine_id")
	private Long medicineId;
	
	@Column(name = "medicine_name", length = 255, nullable = false)
	private String medicineName;
	
	@Column(name = "medicine_brand", length = 255, nullable = false)
	private String medicineBrand;
	
	@Column(name = "medicine_description", length = 255, nullable = false)
	private String medicineDescription;
	
	@Column(name = "medicine_availability", length = 15, nullable = false)
	private String medicineAvailability;
	
	@Column(name = "medicine_type", length = 50, nullable = false)
	private String medicineType;
	
	@Column(name = "medicine_price", nullable = false)
	private double medicinePrice;

	public Medicines() {
	}

	public Medicines(Long medicineId, String medicineName, String medicineBrand, String medicineDescription,
			String medicineAvailability, String medicineType, double medicinePrice) {
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineBrand = medicineBrand;
		this.medicineDescription = medicineDescription;
		this.medicineAvailability = medicineAvailability;
		this.medicineType = medicineType;
		this.medicinePrice = medicinePrice;
	}

	public Long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineBrand() {
		return medicineBrand;
	}

	public void setMedicineBrand(String medicineBrand) {
		this.medicineBrand = medicineBrand;
	}

	public String getMedicineDescription() {
		return medicineDescription;
	}

	public void setMedicineDescription(String medicineDescription) {
		this.medicineDescription = medicineDescription;
	}

	public String getMedicineAvailability() {
		return medicineAvailability;
	}

	public void setMedicineAvailability(String medicineAvailability) {
		this.medicineAvailability = medicineAvailability;
	}

	public String getMedicineType() {
		return medicineType;
	}

	public void setMedicineType(String medicineType) {
		this.medicineType = medicineType;
	}

	public double getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	@Override
	public String toString() {
		return "Medicines [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineBrand="
				+ medicineBrand + ", medicineDescription=" + medicineDescription + ", medicineAvailability="
				+ medicineAvailability + ", medicineType=" + medicineType + ", medicinePrice=" + medicinePrice + "]";
	}

}
