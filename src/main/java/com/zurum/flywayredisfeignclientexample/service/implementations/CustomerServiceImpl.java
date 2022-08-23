package com.zurum.flywayredisfeignclientexample.service.implementations;

import com.zurum.flywayredisfeignclientexample.dto.request.CreateCustomerRequest;
import com.zurum.flywayredisfeignclientexample.dto.request.UpdateCustomerRequest;
import com.zurum.flywayredisfeignclientexample.dto.response.GetCustomerResponse;
import com.zurum.flywayredisfeignclientexample.model.Customer;
import com.zurum.flywayredisfeignclientexample.repository.CustomerRepository;
import com.zurum.flywayredisfeignclientexample.service.CustomerService;
import com.zurum.flywayredisfeignclientexample.utils.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public String registerCustomer(CreateCustomerRequest customerRequest) {

//        if(isCustomerAvailable())
        return null;
    }

    @Override
    public GetCustomerResponse getCustomerById(String id) {
        return ModelMapperUtils.map(customerRepository.findByIdString(id).orElseThrow(() -> {
           throw new RuntimeException("Not found");
        }), GetCustomerResponse.class);
    }

    @Override
    public String updateCustomer(String id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerRepository.findByIdString(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });

        ModelMapperUtils.map(updateCustomerRequest, customer);
        return "yes";
    }

    @Override
    public String deleteCustomer(final String id) {
        if (isCustomerAvailable(id)) {
            customerRepository.deleteById(customerRepository.findByIdString(id).get().getCustomerId());
        }
        throw new RuntimeException("Not found");
    }

    private boolean isCustomerAvailable(String id) {
        return customerRepository.findByIdString(id).isPresent();

    }
}
