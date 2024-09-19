package com.example.fakestoreproductservice.controller;

import com.example.fakestoreproductservice.dto.FakeStoreProductDTO;
import com.example.fakestoreproductservice.model.Product;
import com.example.fakestoreproductservice.service.FakestoreProductserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        return ResponseEntity.ok(fakestoreProductservice.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") long id) {
        return ResponseEntity.ok(fakestoreProductservice.deleteProductById(id));
    }

    @GetMapping("/categories")
    public List<String> getAllCatagories() {
        return  fakestoreProductservice.getAllCategories();
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return  fakestoreProductservice.getAllProducts();
    }

    @GetMapping("/limited")
    public List<Product> getLimitedProducts(@RequestParam int limit) {
        return  fakestoreProductservice.getLimitedProducts(limit);
    }
}
