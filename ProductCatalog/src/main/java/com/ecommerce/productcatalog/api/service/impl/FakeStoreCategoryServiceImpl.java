package com.ecommerce.productcatalog.api.service.impl;

import com.ecommerce.productcatalog.api.Helper.ApiHelper;
import com.ecommerce.productcatalog.api.client.fakestoreapi.FakeStoreClient;
import com.ecommerce.productcatalog.api.dto.CategoryResponseDto;
import com.ecommerce.productcatalog.api.model.Product;
import com.ecommerce.productcatalog.api.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreCategoryServiceImpl")
public class FakeStoreCategoryServiceImpl implements CategoryService {

    private FakeStoreClient client;

    private ApiHelper apiHelper;

    public FakeStoreCategoryServiceImpl(FakeStoreClient client, ApiHelper apiHelper) {
        this.client = client;
        this.apiHelper = apiHelper;
    }

    @Override
    public List<Product> getProductInCategory(String categoryName) {

        List<CategoryResponseDto> productInCategory = client.getProductInCategory(categoryName);

        List<Product> products = new ArrayList<>();

        if (products == null) {
            return null;
        }

        for (CategoryResponseDto categoryResponseDto : productInCategory) {
            products.add(apiHelper.convertCategoryResponseDtoToProduct(categoryResponseDto));
        }

        return products;
    }

    @Override
    public List<String> getAllCategory() {

        List<String> allCategory = client.getAllCategory();

        if (allCategory==null){
            return List.of();
        }

        return allCategory;
    }
}
