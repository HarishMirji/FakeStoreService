package com.example.fakestoreproductservice.services;

import com.example.fakestoreproductservice.dtos.FakeStoreProductDTO;
import com.example.fakestoreproductservice.exceptions.ProductNotFoundException;
import com.example.fakestoreproductservice.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakestoreProductserviceImpl implements ProductService{

    private static final String url = "https://fakestoreapi.com/products";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Product creaateProduct(String name, String description, int price, String image, String category ) {

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(name);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setCategory(category);

        FakeStoreProductDTO response  = restTemplate.postForObject(url, fakeStoreProductDTO, FakeStoreProductDTO.class);

        return  response.toConvertProduct();
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(url + "/" + id, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO == null) {
            throw new ProductNotFoundException("Product with id " + id +" is not found, retry with correct id");
        }
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
    public List<Product> getInCatagory(String category) {
        FakeStoreProductDTO[] response = restTemplate.getForObject(url+ "/category"+"/"+category, FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : response){
            products.add(fakeStoreProductDTO.toConvertProduct());
        }
        return products;
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

    @Override
    public Product updateProductById(long id, String name, String description, int price, String image, String category) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(name);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setImage(image);
        fakeStoreProductDTO.setCategory(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HttpEntity (body + headers)
        HttpEntity<FakeStoreProductDTO> requestEntity = new HttpEntity<>(fakeStoreProductDTO, headers);
        FakeStoreProductDTO response = restTemplate.exchange(url + "/" + id, HttpMethod.PUT, requestEntity, FakeStoreProductDTO.class).getBody();
        return response.toConvertProduct();
    }
}
