package com.ecommerce.productcatalog.api.inheritance.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTTaRepository extends JpaRepository<TA, Long> {

    TA save(TA user);
    TA findTAById(Long id);
}
