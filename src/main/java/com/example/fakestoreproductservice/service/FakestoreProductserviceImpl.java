package com.example.fakestoreproductservice.service;

import com.example.fakestoreproductservice.dto.FakeStoreProductDTO;
import com.example.fakestoreproductservice.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakestoreProductserviceImpl implements ProductService{

    @Override
    public Product creaateProduct(String name, String description, int price, String image, String category ) {
        String url = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = new RestTemplate();

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setName(name);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setCategory(category);

        FakeStoreProductDTO response  = restTemplate.postForObject(url, fakeStoreProductDTO, FakeStoreProductDTO.class);

        return  response.toConvertProduct();
    }

    @Override
    public List<String> getAllCategories() {
        String url = "https://fakestoreapi.com/products/categories";
        RestTemplate restTemplate = new RestTemplate();
        String[] response = restTemplate.getForObject(url, String[].class);
        return Arrays.asList(response);
    }

    @Override
    public List<Product> getAllProducts() {
        String url = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDTO[] response = restTemplate.getForObject(url, FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : response){
            products.add(fakeStoreProductDTO.toConvertProduct());
        }
        return products;
    }
}
