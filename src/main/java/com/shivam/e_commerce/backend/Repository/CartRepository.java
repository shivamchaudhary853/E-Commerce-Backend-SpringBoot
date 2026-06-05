package com.shivam.e_commerce.backend.Repository;

import com.shivam.e_commerce.backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
