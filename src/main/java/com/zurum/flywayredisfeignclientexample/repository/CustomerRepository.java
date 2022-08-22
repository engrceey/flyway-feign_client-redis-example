package com.zurum.flywayredisfeignclientexample.repository;

import com.zurum.flywayredisfeignclientexample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
