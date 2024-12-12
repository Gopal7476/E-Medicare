import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItems } from '../models/cartItems.model';
import { CartItemsService } from '../services/cartItems.service';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css']
})

export class PaymentsComponent implements OnInit {
    cartItems: CartItems[] = []; 
    
    payment = { cardNumber: '', 
                cardHolderName: '', 
                expiryDate: '', 
                cvv: '' 
              }; 
  
  constructor(private router: Router, private cartItemsService: CartItemsService, private userService: UsersService) { } 
  
  ngOnInit(): void { 
    this.loadCartItems(); 
  } 
  
  loadCartItems(): void { 
    this.cartItemsService.getAllCartItems().subscribe(data => { 
      this.cartItems = data; 
    }); 
  } 
    
  getTotal(): number { 
      return this.cartItems.reduce((total, item) => total + item.subTotal, 0); 
  } 
    
  onPay(): void { 
    console.log('Payment details:', this.payment); 
    alert('Payment successful!');
    const userId = this.userService.getUserId();
    console.log("delete in cart: ", userId);
    this.cartItemsService.deleteCartItemByUserId(userId).subscribe(
      () => {
        console.log('Cart items deleted successfully');
        this.router.navigate(['/userhome']);
      },
      error => {
        console.error('Failed to delete cart items', error);
      }
    );
  }
}
