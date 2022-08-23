package com.zurum.flywayredisfeignclientexample.service;

import com.zurum.flywayredisfeignclientexample.dto.request.CreateCustomerRequest;
import com.zurum.flywayredisfeignclientexample.dto.request.UpdateCustomerRequest;
import com.zurum.flywayredisfeignclientexample.dto.response.GetCustomerResponse;

public interface CustomerService {
    String registerCustomer(CreateCustomerRequest customerRequest);
    GetCustomerResponse getCustomerById(String id);

    String updateCustomer(String id, UpdateCustomerRequest updateCustomerRequest);

    String deleteCustomer(String id);
}
