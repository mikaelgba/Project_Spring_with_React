package com.backend.foodDeliver.service;
import com.backend.foodDeliver.DTO.ProductDTO;
import com.backend.foodDeliver.entities.Product;
import com.backend.foodDeliver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findALl(){
        List<Product> list = productRepository.findAllByOrderByNameAsc();
        return list.stream().map(entity -> new ProductDTO(entity)).collect(Collectors.toList());
    }

}
