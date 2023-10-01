package com.ecommerce.productcatalog.api.dto;

import com.ecommerce.productcatalog.api.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryResponseDto extends BaseModel {

    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
    //private RatingDto rating;

}
