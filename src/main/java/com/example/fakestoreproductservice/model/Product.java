package com.example.fakestoreproductservice.model;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private int productPrice;
    private String imageUrl;
    private Category category;

}
