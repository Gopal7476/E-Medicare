package com.emedicare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.emedicare.entities.CartItems;
import com.emedicare.entities.Medicines;
import com.emedicare.entities.Users;
import com.emedicare.repositories.CartItemsRepository;
import com.emedicare.repositories.MedicinesRepository;
import com.emedicare.repositories.UsersRepository;

import jakarta.transaction.Transactional;

@Service(value = "cartItemService")
@Scope(value = "singleton")
@Transactional
public class CartItemsService {
	
	@Autowired
	@Qualifier(value = "medicineRepository")
	private MedicinesRepository medicineRepository;
	
	@Autowired
	@Qualifier(value = "cartItemRepository")
	private CartItemsRepository cartItemRepository;
	
	@Autowired 
	@Qualifier(value = "userRepository") 
	private UsersRepository userRepository; 
	
	public List<CartItems> getCartItemsByUserId(Long userId) { 
		List<CartItems> cartItems = cartItemRepository.findByUserId(userId);
        System.out.println("User ID: " + userId + ", Cart Items: " + cartItems.size());
        return cartItems;
	}
	
	public List<CartItems> getAllCartItems() {
		return cartItemRepository.findAll();
	}
	
	public void addToCart(Long medicineId, Long userId) {
//		Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
		Medicines medicine = medicineRepository.findById(medicineId).orElseThrow(() -> new RuntimeException("Medicine Not Found"));
		CartItems existingCartItem = cartItemRepository.findByUserIdAndMedicineId(userId, medicineId);
		if(existingCartItem == null) {
			CartItems cartItem = new CartItems();
			cartItem.setMedicineId(medicine.getMedicineId());
			cartItem.setMedicineName(medicine.getMedicineName());
			cartItem.setCartQuantity(1);
			cartItem.setProductPrice(medicine.getMedicinePrice());
			cartItem.setSubTotal(medicine.getMedicinePrice());
			cartItem.setUserId(userId);
			
			cartItemRepository.save(cartItem);
		}
		
	}
	
	public CartItems updateCartQuantityAndSubPrice(Long cartId, boolean increment) {
		CartItems cartItem = cartItemRepository.findById(cartId).orElseThrow(() -> new RuntimeException("CartItem Not Found"));
		
		if(increment) {
			cartItem.setCartQuantity(cartItem.getCartQuantity() + 1);
		}
		else {
			if(cartItem.getCartQuantity() >= 1) {
				cartItem.setCartQuantity(cartItem.getCartQuantity() - 1);
			}
		}
		
		cartItem.setSubTotal(cartItem.getCartQuantity() * cartItem.getProductPrice());
		cartItemRepository.save(cartItem);
		return cartItem;
		
	}
	
	public void deleteCartItem(Long cartId) {
		cartItemRepository.deleteById(cartId);
	}
	
	public void deleteCartItemByUserId(Long userId) {
		cartItemRepository.deleteByUserId(userId);
	}


}
