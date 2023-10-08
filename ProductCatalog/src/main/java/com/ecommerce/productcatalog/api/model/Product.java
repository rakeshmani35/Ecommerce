package com.ecommerce.productcatalog.api.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {
    private String title;
    private double price;
    private String description;
    // P : C
    // 1 : 1
    // M : 1
    @ManyToOne(cascade= CascadeType.ALL)
    private Category category;
    private String imageUrl;


}
