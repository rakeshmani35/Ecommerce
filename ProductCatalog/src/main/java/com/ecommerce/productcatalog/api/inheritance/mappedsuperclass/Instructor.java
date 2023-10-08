package com.ecommerce.productcatalog.api.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msct_instructor")
public class Instructor extends User {
    private boolean isHandsome;
}
