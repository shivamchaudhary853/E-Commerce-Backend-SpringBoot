package com.shivam.e_commerce.backend.controller;

import com.shivam.e_commerce.backend.entity.CartItem;
import com.shivam.e_commerce.backend.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/add")
    public CartItem ADdToCart(@RequestBody CartItem cartItem){
        return cartService.AddToCart(cartItem);
    }
    @GetMapping("/all")
    public List<CartItem> GetAllcartItems(){
        return cartService.getAllCartItems();
    }
    @PostMapping("/remove/{id}")
    public String RemoveFromCart(@PathVariable Long id){
        cartService.removeFromCart(id);
        return "Item removed from cart";
    }
}
