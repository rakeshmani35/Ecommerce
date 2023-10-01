package com.ecommerce.productcatalog.api.service;


import com.ecommerce.productcatalog.api.dto.ProductRequestDto;
import com.ecommerce.productcatalog.api.dto.ProductResponseDto;
import com.ecommerce.productcatalog.api.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getSingleProduct(Long productId);

    Product addNewProduct(Product product);

    /*
    Product object has only those fields filled which need to be updated.
    Everything else is null
     */
    Product updateProduct(Long productId, Product requestDto);


    boolean deleteProduct(Long productId);


}
