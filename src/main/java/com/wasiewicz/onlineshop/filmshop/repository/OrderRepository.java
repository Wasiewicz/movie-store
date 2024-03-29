package com.wasiewicz.onlineshop.filmshop.repository;

import com.wasiewicz.onlineshop.filmshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUserId(Long id);

    void deleteByUserId(Long userId);
}
