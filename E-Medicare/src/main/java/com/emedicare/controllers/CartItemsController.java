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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emedicare.entities.CartItems;
import com.emedicare.services.CartItemsService;

@RestController
@RequestMapping("/cart")
@Scope(value = "request")
@CrossOrigin(origins = "http://localhost:4200")
public class CartItemsController {
	
	@Autowired
	@Qualifier(value = "cartItemService")
	private CartItemsService cartItemService;
	
	@GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(value = HttpStatus.OK)
	public List<CartItems> getCartItemsByUserId(@PathVariable Long userId) {
		return cartItemService.getCartItemsByUserId(userId);
	}
	
	@GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(value = HttpStatus.OK)
	public List<CartItems> getAllCartItems() {
		return cartItemService.getAllCartItems();
	}
	
	@PostMapping(value = "/{medicineId}/{userId}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addToCart(@PathVariable Long medicineId, @PathVariable Long userId) {
		cartItemService.addToCart(medicineId, userId);
	}
	
	@PutMapping(value = "/update/{cartId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(value = HttpStatus.OK)
	public CartItems updateCartQuantityAndSubPrice(@PathVariable Long cartId, @RequestParam boolean increment) {
		return cartItemService.updateCartQuantityAndSubPrice(cartId, increment);
	}
	
	@DeleteMapping(value = "/delete/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCartItem(@PathVariable Long cartId) {
		cartItemService.deleteCartItem(cartId);
	}
	
	@DeleteMapping(value = "/delete/userId/{userId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCartItemByUserId(@PathVariable Long userId) {
		cartItemService.deleteCartItemByUserId(userId);
	}

}
