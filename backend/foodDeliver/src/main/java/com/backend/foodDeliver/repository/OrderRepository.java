package com.backend.foodDeliver.repository;
import com.backend.foodDeliver.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository <Order, Long> {

    @Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products  "
            + " WHERE obj.status = 0 ORDER BY obj.moment ASC")
    List<Order> findOrdersWithProducts();
    Optional<Order> findById(Long id);
}