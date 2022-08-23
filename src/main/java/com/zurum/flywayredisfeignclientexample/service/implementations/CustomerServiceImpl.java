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
    public String registerCustomer(final CreateCustomerRequest customerRequest) {

        if (customerRepository.findCustomerByEmail(customerRequest.getEmail()).isPresent())
                throw new RuntimeException("Already exist, login");

        customerRepository.save(ModelMapperUtils.map(customerRequest, new Customer()));
        return "saved";
    }

    @Override
    public GetCustomerResponse getCustomerById(String id) {
        return ModelMapperUtils.map(customerRepository.findCustomerByIdString(id).orElseThrow(() -> {
           throw new RuntimeException("Not found");
        }), GetCustomerResponse.class);
    }

    @Override
    public String updateCustomer(String id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerRepository.findCustomerByIdString(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });

        ModelMapperUtils.map(updateCustomerRequest, customer);
        return "yes";
    }

    @Override
    public String deleteCustomer(final String id) {
        if (isCustomerAvailable(id)) {
            customerRepository.deleteById(customerRepository.findCustomerByIdString(id).get().getCustomerId());
        }
        throw new RuntimeException("Not found");
    }

    private boolean isCustomerAvailable(String id) {
        return customerRepository.findCustomerByIdString(id).isPresent();
    }
}
