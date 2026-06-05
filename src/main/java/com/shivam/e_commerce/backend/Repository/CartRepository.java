package com.shivam.e_commerce.backend.Repository;

import com.shivam.e_commerce.backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
