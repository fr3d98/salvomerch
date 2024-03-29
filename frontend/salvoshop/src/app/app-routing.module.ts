import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ShopComponent} from "./shop/shop.component";
import {CartComponent} from "./cart/cart.component";
import {CheckoutComponent} from "./checkout/checkout.component";
import {OrdersComponent} from "./orders/orders.component";


const routes: Routes = [
  { path : 'shop', component : ShopComponent},
  { path: 'cart', component : CartComponent},
  { path : 'orders', component : OrdersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
