package com.ecommerce.productcatalog.api.inheritance.singleclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SCTaRepository extends JpaRepository<TA, Long> {

    TA save(TA user);
    TA findTAById(Long id);
}
