package com.ecommerce.productcatalog.api.dto;

import com.ecommerce.productcatalog.api.model.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequestDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
    private RatingDto rating;
}
