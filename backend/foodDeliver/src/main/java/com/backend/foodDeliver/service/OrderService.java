package com.backend.foodDeliver.service;
import com.backend.foodDeliver.DTO.OrderDTO;
import com.backend.foodDeliver.DTO.ProductDTO;
import com.backend.foodDeliver.entities.Order;
import com.backend.foodDeliver.entities.OrderStatus;
import com.backend.foodDeliver.entities.Product;
import com.backend.foodDeliver.repository.OrderRepository;
import com.backend.foodDeliver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findALl(){
        List<Order> list = orderRepository.findOrdersWithProducts();
        return list.stream().map(entity -> new OrderDTO(entity)).collect(Collectors.toList());
    }
    @Transactional
    public OrderDTO saveOrder(OrderDTO orderDTO){
        Order order = new Order(null, orderDTO.getAddress(),
                orderDTO.getLatitude(), orderDTO.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for(ProductDTO product : orderDTO.getProducts()){
            Product newProduct = productRepository.getOne(product.getId());
            order.getProducts().add(newProduct);
        }
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }
    @Transactional
    public OrderDTO updateOrderDelivered(Long id){
        Order order = orderRepository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }
}
