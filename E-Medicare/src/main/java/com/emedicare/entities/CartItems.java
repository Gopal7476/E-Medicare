package com.emedicare.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartItemsDetails")
public class CartItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Long cartId;
	
	@Column(name = "medicine_id", nullable = false)
	private Long medicineId;
	
	@Column(name = "medicine_name", length = 255, nullable = false)
	private String medicineName;
	
	@Column(name = "cart_quantity", nullable = false)
	private int cartQuantity;
	
	@Column(name = "product_price", nullable = false)
	private double productPrice;
	
	@Column(name = "sub_total", nullable = false)
	private double subTotal;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;

	public CartItems() {
	}

	public CartItems(Long cartId, Long medicineId, String medicineName, int cartQuantity, double productPrice,
			double subTotal, Long userId) {
		this.cartId = cartId;
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.cartQuantity = cartQuantity;
		this.productPrice = productPrice;
		this.subTotal = subTotal;
		this.userId = userId;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
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

	public int getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CartItems [cartId=" + cartId + ", medicineId=" + medicineId + ", medicineName=" + medicineName
				+ ", cartQuantity=" + cartQuantity + ", productPrice=" + productPrice + ", subTotal=" + subTotal
				+ ", userId=" + userId + "]";
	}
	
}