import { Component, OnInit } from '@angular/core';
import { CartItems } from '../models/cartItems.model';
import { CartItemsService } from '../services/cartItems.service';
import { Router } from '@angular/router';
import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-cartitems',
  templateUrl: './cartitems.component.html',
  styleUrls: ['./cartitems.component.css']
})
export class CartitemsComponent implements OnInit {
  cartItems: CartItems[] = [];

  constructor(private cartItemsService: CartItemsService, private userService: UsersService, private router: Router) { }

  ngOnInit(): void {
    this.loadCartItems();
  }

  loadCartItems(): void {
    const userId = this.userService.getUserId();
    console.log("userId in cart: ", userId);
    this.cartItemsService.getCartItemsByUserId(userId).subscribe(data => {
      this.cartItems = data;
    });
  }

  updateCartQuantityAndSubPrice(cartId: number, increment: boolean): void {
    this.cartItemsService.updateCartQuantityAndSubPrice(cartId, increment).subscribe(() => {
      this.loadCartItems();
    });
  }

  deleteCartItem(cartId: number): void {
    this.cartItemsService.deleteCartItem(cartId).subscribe(() => {
      this.cartItems = this.cartItems.filter(item => item.cartId !== cartId);
    });
  }

  getTotal(): number { 
    return this.cartItems.reduce((total, item) => total + item.subTotal, 0); 
  }

  proceedToPay(): void {
    this.router.navigate(['/payments']);
  }
}