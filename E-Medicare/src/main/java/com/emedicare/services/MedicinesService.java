package com.emedicare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.emedicare.entities.Medicines;
import com.emedicare.repositories.MedicinesRepository;

import jakarta.transaction.Transactional;

@Service(value = "medicineService")
@Scope(value = "singleton")
@Transactional
public class MedicinesService {

	@Autowired
	@Qualifier(value = "medicineRepository")
	private MedicinesRepository medicineRepository;

	public List<Medicines> getAllMedicines() {
		return medicineRepository.findAll();
	}

	public Medicines getMedicineById(Long id) {
		return medicineRepository.findById(id).orElse(null);
	}

	public Medicines addMedicine(Medicines medicine) {
		return medicineRepository.save(medicine);
	}

	public Medicines updateMedicine(Long id, Medicines updateMedicine) {
		if(medicineRepository.existsById(id)) {
			updateMedicine.setMedicineId(id);
			return medicineRepository.save(updateMedicine);
		}
		return null;
	}

	public void deleteMedicine(Long id) {
		medicineRepository.deleteById(id);
	}
	
}
