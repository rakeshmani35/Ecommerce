package com.ecommerce.productcatalog.api.service.impl;

import com.ecommerce.productcatalog.api.Helper.ApiHelper;
import com.ecommerce.productcatalog.api.client.fakestoreapi.FakeStoreClient;
import com.ecommerce.productcatalog.api.client.fakestoreapi.FakeStoreProductDto;
import com.ecommerce.productcatalog.api.dto.ProductRequestDto;
import com.ecommerce.productcatalog.api.dto.ProductResponseDto;
import com.ecommerce.productcatalog.api.model.Category;
import com.ecommerce.productcatalog.api.model.Product;
import com.ecommerce.productcatalog.api.service.ProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("fakeStroreProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    private RestTemplateBuilder templateBuilder;

    private FakeStoreClient client;

    private ApiHelper apiHelper;

    public FakeStoreProductServiceImpl(RestTemplateBuilder builder, FakeStoreClient client, ApiHelper apiHelper) {
        this.templateBuilder = builder;
        this.client = client;
        this.apiHelper = apiHelper;
    }

    @Override
    public List<Product> getAllProducts() {
        List<FakeStoreProductDto> allProduct = client.getAllProduct();
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto productDto : allProduct) {
            products.add(apiHelper.convertFakeStoreProductDtoToProduct(productDto));
        }
        return products;
    }


    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        FakeStoreProductDto singleProduct = client.getSingleProduct(productId);

        if (singleProduct==null){
            return Optional.empty();
        }

        return Optional.of(apiHelper.convertFakeStoreProductDtoToProduct(singleProduct));
    }

    @Override
    public Product addNewProduct(Product product) {

        ProductRequestDto requestDto = apiHelper.convertProductToProductRequestDto(product);

        FakeStoreProductDto fakeStoreProductDto = client.addNewProduct(requestDto);

        return apiHelper.convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        ProductRequestDto productRequestDto = apiHelper.convertProductToProductRequestDto(product);
        FakeStoreProductDto fakeStoreProductDto = client.updateProduct(productId, productRequestDto);
        return apiHelper.convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public boolean deleteProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto = client.deleteProduct(productId);
         if (fakeStoreProductDto==null){
             return false;
         }
        return true;
    }

}
