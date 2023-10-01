package com.ecommerce.productcatalog.api.controller;

import com.ecommerce.productcatalog.api.Helper.ApiHelper;
import com.ecommerce.productcatalog.api.dto.CategoryResponseDto;
import com.ecommerce.productcatalog.api.exception.NotFoundException;
import com.ecommerce.productcatalog.api.model.Product;
import com.ecommerce.productcatalog.api.service.impl.FakeStoreCategoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private FakeStoreCategoryServiceImpl service;
    private ApiHelper apiHelper;

    public CategoryController(FakeStoreCategoryServiceImpl fakeStoreCategoryService, ApiHelper apiHelper) {
        this.service = fakeStoreCategoryService;
        this.apiHelper = apiHelper;
    }

    @GetMapping
    public List<String> getAllCategory() throws NotFoundException {

        List<String> allCategory = service.getAllCategory();
        if (!Objects.nonNull(allCategory)) {
            throw new NotFoundException("categories are not available for catogery");
        }

        return allCategory;
    }

    @GetMapping("/{categoryName}")
    public List<CategoryResponseDto> getProductInCategory(@PathVariable String categoryName) throws NotFoundException {

        List<Product> productInCategoryList = service.getProductInCategory(categoryName);

        if (!Objects.nonNull(productInCategoryList)) {
            throw new NotFoundException("products is not available for catogery - " + categoryName);
        }

        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        for (Product product : productInCategoryList) {
            categoryResponseDtos.add(apiHelper.convertProductToCategoryResponseDto(product));
        }

        return categoryResponseDtos;
    }

}
