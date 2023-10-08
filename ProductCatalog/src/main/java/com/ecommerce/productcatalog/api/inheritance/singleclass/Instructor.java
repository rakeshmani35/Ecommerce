package com.ecommerce.productcatalog.api.inheritance.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sct_instructor")
@DiscriminatorValue("2")
public class Instructor extends User {
    private boolean isHandsome;
}
