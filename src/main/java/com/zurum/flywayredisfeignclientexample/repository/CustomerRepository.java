package com.zurum.flywayredisfeignclientexample.repository;

import com.zurum.flywayredisfeignclientexample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerByIdString(String id);
    Optional<Customer> findCustomerByEmail(String email);
}