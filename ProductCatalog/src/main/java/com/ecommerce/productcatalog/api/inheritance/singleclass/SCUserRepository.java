package com.ecommerce.productcatalog.api.inheritance.singleclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SCUserRepository extends JpaRepository<User, Long> {

    User save(User user);
    User findUserById(Long id);

}
