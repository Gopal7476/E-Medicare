package com.emedicare.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usersDetails")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "user_first_name", length = 255, nullable = false)
	private String userFirstName;
	
	@Column(name = "user_last_name", length = 255, nullable = false)
	private String userLastName;
	
	@Column(name = "user_name", length = 255, nullable = false)
	private String userName;
	
	@Column(name = "user_password", length = 255, nullable = false)
	private String userPassword;
	
	@Column(name = "user_email", length = 50, nullable = false)
	private String userEmail;
	
	@Column(name = "user_phone_number", length = 10, nullable = false)
	private String userPhoneNumber;
	
	@Column(name = "user_gender", length = 6, nullable = false)
	private String userGender;
	
	@Column(name = "user_address", length = 255, nullable = false)
	private String userAddress;
	
	@Column(name = "user_district", length = 255, nullable = false)
	private String userDistrict;
	
	@Column(name = "user_state", length = 255, nullable = false)
	private String userState;
	
	@Column(name = "user_zipcode", length = 6, nullable = false)
	private String userZipCode;
	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
//	private Set<CartItems> cartItems;

	public Users() {
	}

	public Users(Long userId, String userFirstName, String userLastName, String userName, String userPassword,
			String userEmail, String userPhoneNumber, String userGender, String userAddress, String userDistrict,
			String userState, String userZipCode, Set<CartItems> cartItems) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userPhoneNumber = userPhoneNumber;
		this.userGender = userGender;
		this.userAddress = userAddress;
		this.userDistrict = userDistrict;
		this.userState = userState;
		this.userZipCode = userZipCode;
//		this.cartItems = cartItems;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserDistrict() {
		return userDistrict;
	}

	public void setUserDistrict(String userDistrict) {
		this.userDistrict = userDistrict;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserZipCode() {
		return userZipCode;
	}

	public void setUserZipCode(String userZipCode) {
		this.userZipCode = userZipCode;
	}

//	public Set<CartItems> getCartItems() {
//		return cartItems;
//	}
//
//	public void setCartItems(Set<CartItems> cartItems) {
//		this.cartItems = cartItems;
//	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail=" + userEmail
				+ ", userPhoneNumber=" + userPhoneNumber + ", userGender=" + userGender + ", userAddress=" + userAddress
				+ ", userDistrict=" + userDistrict + ", userState=" + userState + ", userZipCode=" + userZipCode
				+ ", cartItems=" + /*cartItems +*/ "]";
	}
	
}