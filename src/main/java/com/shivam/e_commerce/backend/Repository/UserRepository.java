package com.shivam.e_commerce.backend.Repository;

import com.shivam.e_commerce.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByemail(String email);
}
