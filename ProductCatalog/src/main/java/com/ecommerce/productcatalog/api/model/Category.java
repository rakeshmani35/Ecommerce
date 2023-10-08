package com.ecommerce.productcatalog.api.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Setter
@Getter
@Entity
public class Category extends BaseModel {

    private String name;
    private String description;
    @OneToMany(mappedBy = "category",cascade= CascadeType.ALL)
    private List<Product> products;
}
