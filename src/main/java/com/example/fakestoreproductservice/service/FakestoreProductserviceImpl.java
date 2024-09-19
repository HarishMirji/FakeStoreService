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

    private String url = "https://fakestoreapi.com/products";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Product creaateProduct(String name, String description, int price, String image, String category ) {

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
    public Product getProductById(long id) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO = restTemplate.getForObject(url + "/" + id, FakeStoreProductDTO.class);
        return  fakeStoreProductDTO.toConvertProduct();
    }

    @Override
    public String deleteProductById(long id) {
        restTemplate.delete(url, id);
        return  "Product with Id "+id+" has been deleted successfully";
    }


    @Override
    public List<String> getAllCategories() {

        String[] response = restTemplate.getForObject(url + "/categories", String[].class);
        return Arrays.asList(response);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] response = restTemplate.getForObject(url, FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : response){
            products.add(fakeStoreProductDTO.toConvertProduct());
        }
        return products;
    }

    @Override
    public List<Product> getLimitedProducts(int limit) {
        FakeStoreProductDTO[] response = restTemplate.getForObject(url + "?limit="+limit, FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : response){
            products.add(fakeStoreProductDTO.toConvertProduct());
        }
        return products;
    }
}
