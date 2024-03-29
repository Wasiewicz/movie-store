import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Cart, CartItem } from 'src/app/models/cart.model';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl:'./cart.componetn.html'
})
export class CartComponent implements OnInit,OnDestroy{

cart: Cart={items: []};
dataSource:Array<CartItem>=[]
cartSubscription: Subscription | undefined;
displayedColumns: string[] = [
  'product',
  'title',
  'price',
  'quantity',
  'total',
  'action',
];
constructor(private cartService: CartService, private http: HttpClient) {}

ngOnInit(): void {
  this.cartSubscription = this.cartService.cart.subscribe((_cart: Cart) => {
    this.cart = _cart;
    this.dataSource = _cart.items;
  });
}

getTotal(items: CartItem[]): number {
  return this.cartService.getTotal(items);
}

onAddQuantity(item: CartItem): void {
  this.cartService.addToCart(item);
}

onRemoveFromCart(item: CartItem): void {
  this.cartService.removeFromCart(item);
}

onRemoveQuantity(item: CartItem): void {
  this.cartService.removeQuantity(item);
}

onClearCart(): void {
  this.cartService.clearCart();
}

onCheckout(): void {
  
}

ngOnDestroy() {
  if (this.cartSubscription) {
    this.cartSubscription.unsubscribe();
  }
}
}
