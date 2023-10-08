package com.ecommerce.productcatalog.api.repository;

import com.ecommerce.productcatalog.api.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    public Product save(Product product);
}
