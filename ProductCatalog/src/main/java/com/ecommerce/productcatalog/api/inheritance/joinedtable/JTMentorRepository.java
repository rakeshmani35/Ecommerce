package com.ecommerce.productcatalog.api.inheritance.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTMentorRepository extends JpaRepository<Mentor, Long> {

    Mentor save(Mentor user);
    Mentor findMentorById(Long id);
}
