package com.shivam.e_commerce.backend.Repository;

import com.shivam.e_commerce.backend.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
