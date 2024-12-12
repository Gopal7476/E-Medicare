package com.emedicare.repositories;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emedicare.entities.CartItems;

@Repository(value = "cartItemRepository")
@Scope(value = "singleton")
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
	
	CartItems findByMedicineId(Long medicineId);
	List<CartItems> findByUserId(Long userId);
	CartItems findByUserIdAndMedicineId(Long userId, Long medicineId);
	void deleteByUserId(Long userId);
	
}
