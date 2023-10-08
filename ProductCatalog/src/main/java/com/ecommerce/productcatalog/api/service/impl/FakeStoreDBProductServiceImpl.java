package com.ecommerce.productcatalog.api.service.impl;

import com.ecommerce.productcatalog.api.Helper.ApiHelper;
import com.ecommerce.productcatalog.api.client.fakestoreapi.FakeStoreClient;
import com.ecommerce.productcatalog.api.client.fakestoreapi.FakeStoreProductDto;
import com.ecommerce.productcatalog.api.dto.ProductRequestDto;
import com.ecommerce.productcatalog.api.model.Product;
import com.ecommerce.productcatalog.api.repository.ProductRepository;
import com.ecommerce.productcatalog.api.service.ProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("fakeStroreDBProductService")
public class FakeStoreDBProductServiceImpl implements ProductService {

    private RestTemplateBuilder templateBuilder;


    private ProductRepository repository;

    public FakeStoreDBProductServiceImpl(RestTemplateBuilder builder,ProductRepository repository) {
        this.templateBuilder = builder;
        this.repository = repository;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }


    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        Optional<Product> productOptional = repository.findById(productId);
        return productOptional;
    }

    @Override
    public Product addNewProduct(Product product) {
        Product saveProduct = repository.save(product);
        return saveProduct;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        
        Optional<Product> productOptional = repository.findById(productId);
        Product saveProduct = null;
        if (!productOptional.isEmpty()) {
            Product p = productOptional.get();
            p.setTitle(product.getTitle());
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setDescription(product.getCategory() != null ? product.getCategory().getName() : null);
            p.setImageUrl(product.getImageUrl());
            p.setCreatedAt(product.getCreatedAt());
            p.setLastUpdatedAt(new Date());

            saveProduct = repository.save(p);
        }
        return saveProduct;
    }

    @Override
    public boolean deleteProduct(Long productId) {

        Optional<Product> productOptional = repository.findById(productId);
        if (!productOptional.isEmpty()) {
            Product product = productOptional.get();
            repository.delete(product);
            return true;
        }
        return false;
    }

}
