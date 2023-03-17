package com.wasiewicz.onlineshop.repository;

import com.wasiewicz.onlineshop.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser,Long> {
    Optional<AppUser>findByEmail(String email);
}
