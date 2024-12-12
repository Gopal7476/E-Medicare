package com.emedicare.repositories;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emedicare.entities.Medicines;

@Repository(value = "medicineRepository")
@Scope(value = "singleton")
public interface MedicinesRepository extends JpaRepository<Medicines, Long> {

}
