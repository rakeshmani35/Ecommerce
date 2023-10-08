package com.ecommerce.productcatalog.api.inheritance.mappedsuperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MSCTInstructorRepository extends JpaRepository<Instructor, Long> {

    Instructor save(Instructor user);
    Instructor findInstructorById(Long id);
}
