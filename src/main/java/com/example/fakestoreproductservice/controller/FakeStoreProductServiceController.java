package com.example.fakestoreproductservice.controller;

import com.example.fakestoreproductservice.dto.FakeStoreProductDTO;
import com.example.fakestoreproductservice.model.Product;
import com.example.fakestoreproductservice.service.FakestoreProductserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class FakeStoreProductServiceController {

    @Autowired
    private FakestoreProductserviceImpl fakestoreProductservice;

    @PostMapping("/create")
    public Product createProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO) {

        return  fakestoreProductservice.creaateProduct(fakeStoreProductDTO.getName(),
                fakeStoreProductDTO.getDescription(),
                fakeStoreProductDTO.getPrice(),
                fakeStoreProductDTO.getImage(),
                fakeStoreProductDTO.getCategory());
    }

    @GetMapping("/categories")
    public List<String> getAllCatagories() {
        return  fakestoreProductservice.getAllCategories();
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return  fakestoreProductservice.getAllProducts();
    }
}
