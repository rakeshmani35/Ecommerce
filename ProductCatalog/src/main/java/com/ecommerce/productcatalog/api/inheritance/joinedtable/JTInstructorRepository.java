package com.ecommerce.productcatalog.api.inheritance.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JTInstructorRepository extends JpaRepository<Instructor, Long> {

    Instructor save(Instructor user);
    Instructor findInstructorById(Long id);
}
