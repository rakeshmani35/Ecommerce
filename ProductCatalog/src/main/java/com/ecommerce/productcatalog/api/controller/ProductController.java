package com.ecommerce.productcatalog.api.controller;

import com.ecommerce.productcatalog.api.Helper.ApiHelper;
import com.ecommerce.productcatalog.api.dto.ErrorResponseDto;
import com.ecommerce.productcatalog.api.dto.ProductRequestDto;
import com.ecommerce.productcatalog.api.dto.ProductResponseDto;
import com.ecommerce.productcatalog.api.exception.NotFoundException;
import com.ecommerce.productcatalog.api.model.Product;
import com.ecommerce.productcatalog.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService fakeStroreProductService;
    private ApiHelper apiHelper;

    public ProductController(ProductService productService, ApiHelper apiHelper) {
        this.fakeStroreProductService = productService;
        this.apiHelper = apiHelper;
    }

    @GetMapping()
    public List<ProductResponseDto> getAllProducts() {

        List<Product> allProducts = fakeStroreProductService.getAllProducts();

        List<ProductResponseDto> responseDtos = new ArrayList<>();
        for (Product product : allProducts) {
            responseDtos.add(apiHelper.convertProductToProductResponseDto(product));
        }

        return responseDtos;
    }

    @GetMapping("/{productId}")
    public ProductResponseDto getSingleProduct(@PathVariable Long productId) throws NotFoundException {

        Optional<Product> productOptional = fakeStroreProductService.getSingleProduct(productId);
        if (productOptional.isEmpty()){
            throw new NotFoundException("No Product found for product id - "+productId);
        }

        return apiHelper.convertProductToProductResponseDto(productOptional.get());
    }

    @PostMapping
    public ProductResponseDto addNewProduct(@RequestBody ProductRequestDto productRequestDto) {

        Product productRquest = apiHelper.convertProductRequestDtoToProduct(productRequestDto);

        Product product = fakeStroreProductService.addNewProduct(productRquest);

        return apiHelper.convertProductToProductResponseDto(product);
    }

    @PatchMapping("/{productId}")
    public ProductResponseDto updareProduct(@PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto) {

        Product productRquest = apiHelper.convertProductRequestDtoToProduct(productRequestDto);

        Product product = fakeStroreProductService.updateProduct(productId, productRquest);

        return apiHelper.convertProductToProductResponseDto(product);
    }

    @DeleteMapping("/{productId}")
    public boolean deleteProduct(@PathVariable Long productId) {
        boolean b = fakeStroreProductService.deleteProduct(productId);

        return b;
    }

//    @ExceptionHandler(NotFoundException.class)
//    private ResponseEntity<ErrorResponseDto> productNotFound(Exception ex){
//        ErrorResponseDto error = new ErrorResponseDto();
//        error.setErrorMessage(ex.getMessage());
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//
//    }

}
