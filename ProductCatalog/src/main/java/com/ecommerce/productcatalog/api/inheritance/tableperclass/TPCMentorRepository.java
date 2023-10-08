package com.ecommerce.productcatalog.api.inheritance.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCMentorRepository extends JpaRepository<Mentor, Long> {

    Mentor save(Mentor user);
    Mentor findMentorById(Long id);
}
