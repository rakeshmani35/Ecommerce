package com.ecommerce.productcatalog.api.inheritance.singleclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SCMentorRepository extends JpaRepository<Mentor, Long> {

    Mentor save(Mentor user);
    Mentor findMentorById(Long id);
}
