package com.ecommerce.productcatalog.api.inheritance.mappedsuperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MSCTMentorRepository extends JpaRepository<Mentor, Long> {

    Mentor save(Mentor user);
    Mentor findMentorById(Long id);
}
