package com.shivam.e_commerce.backend.service;

import com.shivam.e_commerce.backend.Repository.CartItemRepository;
import com.shivam.e_commerce.backend.Repository.CartRepository;
import com.shivam.e_commerce.backend.entity.Cart;
import com.shivam.e_commerce.backend.entity.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private  final CartItemRepository cartItemRepository;


    public CartItem AddToCart(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }
    public List<CartItem> getAllCartItems(){
        return cartItemRepository.findAll();
    }
    public void removeFromCart(Long id){
        cartItemRepository.deleteById(id);
    }
}
