package com.backend.foodDeliver.repository;
import com.backend.foodDeliver.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}