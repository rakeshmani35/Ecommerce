package com.ecommerce.productcatalog.api.inheritance.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCTaRepository extends JpaRepository<TA, Long> {

    TA save(TA user);
    TA findTAById(Long id);
}
