package com.example.fakestoreproductservice.dtos;

import com.example.fakestoreproductservice.models.Category;
import com.example.fakestoreproductservice.models.Product;
import lombok.Data;

@Data
public class FakeStoreProductDTO {

    private long id;
    private String title;
    private String description;
    private int price;
    private String image;
    private String category;

    public Product toConvertProduct(){
        Product product = new Product();
        product.setProductId(id);
        product.setProductName(title);
        product.setProductDescription(description);
        product.setProductPrice(price);
        product.setImageUrl(image);

        Category cat = new Category();
        cat.setCategoryName(category);
        product.setCategory(cat);

        return product;
    }
}
