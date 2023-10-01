package com.ecommerce.productcatalog.api.client.fakestoreapi;

import com.ecommerce.productcatalog.api.dto.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;
    private RatingDto rating;
}
