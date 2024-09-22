package com.example.fakestoreproductservice.services;


import com.example.fakestoreproductservice.exceptions.ProductNotFoundException;
import com.example.fakestoreproductservice.models.Product;

import java.util.List;

public interface ProductService {
    Product creaateProduct(String name, String description, int price, String image, String category);
    Product getProductById(long id) throws ProductNotFoundException;
    String deleteProductById(long id);
    List<String> getAllCategories();
    List<Product> getInCatagory(String category);
    List<Product> getAllProducts();
    List<Product> getLimitedProducts(int limit);
    Product updateProductById(long id, String name, String description, int price, String image, String category);
}
