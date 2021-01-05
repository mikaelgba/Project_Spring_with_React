package com.backend.foodDeliver.controller;
import com.backend.foodDeliver.DTO.OrderDTO;
import com.backend.foodDeliver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        List<OrderDTO> list = orderService.findALl();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO orderDTO){
        return new ResponseEntity<>(orderService.saveOrder(orderDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Long id){
        OrderDTO orderDTO = orderService.updateOrderDelivered(id);
        return new ResponseEntity<>(orderDTO, HttpStatus.NO_CONTENT);
    }
}