package com.example.fakestoreproductservice.models;

import lombok.Data;

@Data
public class Product {
    private long productId;
    private String productName;
    private String productDescription;
    private int productPrice;
    private String imageUrl;
    private Category category;

}
