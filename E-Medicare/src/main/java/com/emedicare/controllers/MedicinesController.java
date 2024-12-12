package com.emedicare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emedicare.entities.Medicines;
import com.emedicare.services.MedicinesService;

@RestController
@RequestMapping("/medicine")
@Scope(value = "request")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicinesController {
	
	@Autowired
	@Qualifier(value = "medicineService")
	private MedicinesService medicineService;
	
	@GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(value = HttpStatus.OK)
	public List<Medicines> getAllMedicines() {
		return medicineService.getAllMedicines();
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(value = HttpStatus.OK)
	public Medicines getMedicineById(@PathVariable Long id) {
		return medicineService.getMedicineById(id);
	}
	
	@PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(value = HttpStatus.CREATED)
	public Medicines addMedicine(@RequestBody Medicines medicine) {
		return medicineService.addMedicine(medicine);
	}
	
	@PutMapping(value = "/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(value = HttpStatus.OK)
	public Medicines updateMedicine(@PathVariable Long id, @RequestBody Medicines medicine) {
		return medicineService.updateMedicine(id, medicine);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteMedicine(@PathVariable Long id) {
		medicineService.deleteMedicine(id);
	}
	
}
