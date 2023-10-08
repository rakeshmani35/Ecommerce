package com.ecommerce.productcatalog.api.inheritance.mappedsuperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MSCTTaRepository extends JpaRepository<TA, Long> {

    TA save(TA user);
    TA findTAById(Long id);
}
