package com.example.fakestoreproductservice.dto;

import com.example.fakestoreproductservice.model.Category;
import com.example.fakestoreproductservice.model.Product;
import lombok.Data;

@Data
public class FakeStoreProductDTO {

    private int id;
    private String name;
    private String description;
    private int price;
    private String image;
    private String category;

    public Product toConvertProduct(){
        Product product = new Product();
        product.setProductId(id);
        product.setProductName(name);
        product.setProductDescription(description);
        product.setProductPrice(price);
        product.setImageUrl(image);

        Category cat = new Category();
        cat.setCategoryName(category);
        product.setCategory(cat);

        return product;
    }
}
