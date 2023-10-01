package com.ecommerce.productcatalog.api.client.fakestoreapi;

import com.ecommerce.productcatalog.api.Helper.ApiHelper;
import com.ecommerce.productcatalog.api.dto.CategoryResponseDto;
import com.ecommerce.productcatalog.api.dto.ProductRequestDto;
import com.ecommerce.productcatalog.api.dto.ProductResponseDto;
import com.ecommerce.productcatalog.api.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder templateBuilder;
    private ApiHelper apiHelper;

    public FakeStoreClient(RestTemplateBuilder builder, ApiHelper apiHelper) {
        this.templateBuilder = builder;
        this.apiHelper = apiHelper;
    }

    public List<FakeStoreProductDto> getAllProduct() {
        RestTemplate template = templateBuilder.build();
        String url = "https://fakestoreapi.com/products";
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDto = template.getForEntity(url, FakeStoreProductDto[].class);
        return Arrays.asList(fakeStoreProductDto.getBody());
    }

    public FakeStoreProductDto getSingleProduct(Long productId) {
        RestTemplate template = templateBuilder.build();
        String url = "https://fakestoreapi.com/products/{productId}";
        ResponseEntity<FakeStoreProductDto> productResponseDto = template.getForEntity(url, FakeStoreProductDto.class, productId);
        FakeStoreProductDto fakeStoreProductDto = productResponseDto.getBody();

        return fakeStoreProductDto;
    }

    public FakeStoreProductDto addNewProduct(ProductRequestDto product) {
        RestTemplate template = templateBuilder.build();
        String url = "https://fakestoreapi.com/products";
        ResponseEntity<FakeStoreProductDto> productDto = template.postForEntity(url, product, FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = productDto.getBody();

        return fakeStoreProductDto;
    }


    public FakeStoreProductDto updateProduct(Long productId, ProductRequestDto product) {
        String url = "https://fakestoreapi.com/products/{productId}";
        ResponseEntity<FakeStoreProductDto> productDtoResponseEntity =
                apiHelper.requestForEntity(HttpMethod.PATCH, url, product, FakeStoreProductDto.class, productId);

        return productDtoResponseEntity.getBody();
    }


    public FakeStoreProductDto deleteProduct(Long productId) {
        String url = "https://fakestoreapi.com/products/{productId}";
        ResponseEntity<FakeStoreProductDto> productDtoResponseEntity =
                apiHelper.requestForEntity(HttpMethod.DELETE, url, null, FakeStoreProductDto.class, productId);
        return productDtoResponseEntity.getBody();
    }


    public List<String> getAllCategory() {
        RestTemplate template = templateBuilder.build();
        String url = "https://fakestoreapi.com/products/categories";
        ResponseEntity<String[]> allCategory = template.getForEntity(url, String[].class);
        return Arrays.asList(allCategory.getBody());
    }
    
    public  List<CategoryResponseDto> getProductInCategory(String categoryName){

        RestTemplate template = templateBuilder.build();
        String url = "https://fakestoreapi.com/products/category/{categoryName}";

        ResponseEntity<CategoryResponseDto[]> responseDto = template.getForEntity(url, CategoryResponseDto[].class, categoryName);

        return List.of(responseDto.getBody());

    }
}
