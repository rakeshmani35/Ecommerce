package com.ecommerce.productcatalog.api.service;

import com.ecommerce.productcatalog.api.model.Product;

import java.util.List;

public interface CategoryService {

    public List<Product> getProductInCategory(String categoryName);

    public List<String> getAllCategory();
}
