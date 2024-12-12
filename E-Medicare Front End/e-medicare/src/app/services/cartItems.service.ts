import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { CartItems } from "../models/cartItems.model";

@Injectable ({
    providedIn: 'root'
})

export class CartItemsService {
    private baseUrl = 'http://localhost:9090/cart';

    constructor(private http: HttpClient) {}

    getCartItemsByUserId(userId: number): Observable<CartItems[]> {
        return this.http.get<CartItems[]>(`${this.baseUrl}/${userId}`);
    }

    getAllCartItems(): Observable<CartItems[]> {
        return this.http.get<CartItems[]>(`${this.baseUrl}`);
    }

    addToCart(medicineId: number, userId: number): Observable<void> {
        return this.http.post<void>(`${this.baseUrl}/${medicineId}/${userId}`, {});
    }

    updateCartQuantityAndSubPrice(cartId: number, increment: boolean): Observable<CartItems> {
        return this.http.put<CartItems>(`${this.baseUrl}/update/${cartId}?increment=${increment}`, {});
    }

    deleteCartItem(cartId: number): Observable<void> {
        return this.http.delete<void>(`${this.baseUrl}/delete/${cartId}`, { responseType: 'json' });
    }

    deleteCartItemByUserId(userId: number): Observable<void> {
        return this.http.delete<void>(`${this.baseUrl}/delete/userId/${userId}`, { responseType: 'json' });
    }

}