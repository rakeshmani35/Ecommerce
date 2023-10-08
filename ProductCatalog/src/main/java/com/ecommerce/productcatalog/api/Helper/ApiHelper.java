package com.ecommerce.productcatalog.api.Helper;

import com.ecommerce.productcatalog.api.client.fakestoreapi.FakeStoreProductDto;
import com.ecommerce.productcatalog.api.dto.CategoryResponseDto;
import com.ecommerce.productcatalog.api.dto.ProductRequestDto;
import com.ecommerce.productcatalog.api.dto.ProductResponseDto;
import com.ecommerce.productcatalog.api.model.Category;
import com.ecommerce.productcatalog.api.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Date;
import java.util.Map;

@Component
public class ApiHelper {

    private RestTemplateBuilder restTemplateBuilder;

    public ApiHelper(RestTemplateBuilder builder) {
        this.restTemplateBuilder = builder;
    }

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                  Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }


    public Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(productDto.getImageUrl());

        return product;
    }

    public FakeStoreProductDto convertFakeStoreProductToProductDto(Product product) {
        FakeStoreProductDto responseDto = new FakeStoreProductDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setDescription(product.getDescription());
        Category category = product.getCategory();
        responseDto.setCategory(category != null ? category.getName() : null);
        responseDto.setImageUrl(product.getImageUrl());

        return responseDto;
    }

    public Product convertProductRequestDtoToProduct(ProductRequestDto productDto) {
        Product product = new Product();
//        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);

        product.setImageUrl(productDto.getImageUrl());
        product.setCreatedAt(new Date());
        product.setLastUpdatedAt(new Date());

        return product;
    }

    public Product convertProductResponseDtoToProduct(ProductResponseDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setImageUrl(productDto.getImageUrl());

        return product;
    }


    public ProductResponseDto convertProductToProductResponseDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setDescription(product.getDescription());
        Category category = product.getCategory();
        responseDto.setCategory(category != null ? category : null);
        responseDto.setImageUrl(product.getImageUrl());

        return responseDto;
    }

    public ProductRequestDto convertProductToProductRequestDto(Product product) {
        ProductRequestDto requestDto = new ProductRequestDto();
        requestDto.setId(product.getId());
        requestDto.setTitle(product.getTitle());
        requestDto.setPrice(product.getPrice());
        requestDto.setDescription(product.getDescription());
        Category category = product.getCategory();
        requestDto.setCategory(category != null ? category.getName() : null);
        requestDto.setImageUrl(product.getImageUrl());

        return requestDto;
    }

    public CategoryResponseDto convertProductToCategoryResponseDto(Product product) {
        CategoryResponseDto responseDto = new CategoryResponseDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setPrice(product.getPrice());
        responseDto.setDescription(product.getDescription());
        Category category = product.getCategory();
        responseDto.setCategory(category != null ? category.getName() : null);
        responseDto.setImage(product.getImageUrl());

        return responseDto;
    }

    public Product convertCategoryResponseDtoToProduct(CategoryResponseDto categoryDto) {
        Product product = new Product();
        product.setId(categoryDto.getId());
        product.setTitle(categoryDto.getTitle());
        product.setPrice(categoryDto.getPrice());
        product.setDescription(categoryDto.getDescription());
        Category category = new Category();
        category.setName(categoryDto.getCategory());
        product.setCategory(category);
        product.setImageUrl(categoryDto.getImage());

        return product;
    }

}
