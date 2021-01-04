package com.backend.foodDeliver.repository;
import com.backend.foodDeliver.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {
}