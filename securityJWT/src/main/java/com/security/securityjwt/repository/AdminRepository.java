package com.security.securityjwt.repository;

import com.security.securityjwt.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository  extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUsername(String username);
}