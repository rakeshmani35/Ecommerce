package com.ecommerce.productcatalog.api.inheritance.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPCInstructorRepository extends JpaRepository<Instructor, Long> {

    Instructor save(Instructor user);
    Instructor findInstructorById(Long id);
}
