package com.ecommerce.productcatalog.api.inheritance.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sct_ta")
@DiscriminatorValue("1")
public class TA extends User {
    private double averageRating;
}
