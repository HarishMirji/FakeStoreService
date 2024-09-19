package com.example.fakestoreproductservice.service;


import com.example.fakestoreproductservice.model.Product;

import java.util.List;

public interface ProductService {
    Product creaateProduct(String name, String description, int price, String image, String category);
    Product getProductById(long id);
    String deleteProductById(long id);
    List<String> getAllCategories();
    List<Product> getAllProducts();
    List<Product> getLimitedProducts(int limit);
}
