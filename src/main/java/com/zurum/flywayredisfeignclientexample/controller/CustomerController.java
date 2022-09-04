package com.zurum.flywayredisfeignclientexample.controller;


import com.zurum.flywayredisfeignclientexample.dto.request.CreateCustomerRequest;
import com.zurum.flywayredisfeignclientexample.dto.request.UpdateCustomerRequest;
import com.zurum.flywayredisfeignclientexample.dto.response.ApiResponse;
import com.zurum.flywayredisfeignclientexample.dto.response.GetCustomerResponse;
import com.zurum.flywayredisfeignclientexample.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(path = "/register")
    public ResponseEntity<ApiResponse<?>> registerUser(@RequestBody @Valid final CreateCustomerRequest customerRequest) {
        log.info("controller register: register user :: [{}] ::", customerRequest.getEmail());
        String response = customerService.registerCustomer(customerRequest);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/customer/register").toUriString());
        return ResponseEntity.created(uri).body(ApiResponse.buildSuccess(response));
    }

    @GetMapping(path = "/customer/{customerId}")
    public ResponseEntity<ApiResponse<?>> getCustomerByCustomerId(@PathVariable("customerId") final String customerId) {
        log.info("fetch customer: By ID:: [{}] ::", customerId);
        GetCustomerResponse response = customerService.getCustomerById(customerId);
        return ResponseEntity.ok().body(ApiResponse.buildSuccess(response));
    }

    @PutMapping(path = "/customer/{customerId}")
    public ResponseEntity<ApiResponse<?>> updateCustomerDetails(@PathVariable("customerId") final String customerId, @Valid @RequestBody final UpdateCustomerRequest updateCustomerRequest) {
        log.info("update customer details: By ID:: [{}] ::", customerId);
        String response = customerService.updateCustomer(customerId,updateCustomerRequest);
        return ResponseEntity.ok().body(ApiResponse.buildSuccess(response));
    }

    @DeleteMapping(path = "{customerId}")
    public ResponseEntity<ApiResponse<?>> deleteCustomer(@PathVariable("customerId") final String customerId) {
        log.info("fetch customer: By ID:: [{}] ::", customerId);
        String response = customerService.deleteCustomer(customerId);
        return ResponseEntity.ok().body(ApiResponse.buildSuccess(response));
    }

}
