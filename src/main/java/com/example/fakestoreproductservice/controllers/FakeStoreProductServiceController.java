package com.example.fakestoreproductservice.controllers;

import com.example.fakestoreproductservice.dtos.FakeStoreProductDTO;
import com.example.fakestoreproductservice.exceptions.ProductNotFoundException;
import com.example.fakestoreproductservice.models.Product;
import com.example.fakestoreproductservice.services.FakestoreProductserviceImpl;
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

        return  fakestoreProductservice.creaateProduct(fakeStoreProductDTO.getTitle(),
                fakeStoreProductDTO.getDescription(),
                fakeStoreProductDTO.getPrice(),
                fakeStoreProductDTO.getImage(),
                fakeStoreProductDTO.getCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
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


    @GetMapping("/categories/{category}")
    public List<Product> getInCatagory(@PathVariable("category") String category) {
        return  fakestoreProductservice.getInCatagory(category);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return  fakestoreProductservice.getAllProducts();
    }

    @GetMapping("/limited")
    public List<Product> getLimitedProducts(@RequestParam int limit) {
        return  fakestoreProductservice.getLimitedProducts(limit);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> udateProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO) {
        Product product =  fakestoreProductservice.updateProductById(fakeStoreProductDTO.getId(),
                fakeStoreProductDTO.getTitle(),
                fakeStoreProductDTO.getDescription(),
                fakeStoreProductDTO.getPrice(),
                fakeStoreProductDTO.getImage(),
                fakeStoreProductDTO.getCategory());
        return ResponseEntity.ok(product);
    }
}
