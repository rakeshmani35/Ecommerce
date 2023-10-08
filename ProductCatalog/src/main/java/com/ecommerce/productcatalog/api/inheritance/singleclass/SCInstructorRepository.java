package com.ecommerce.productcatalog.api.inheritance.singleclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SCInstructorRepository extends JpaRepository<Instructor, Long> {

    Instructor save(Instructor user);
    Instructor findInstructorById(Long id);
}
