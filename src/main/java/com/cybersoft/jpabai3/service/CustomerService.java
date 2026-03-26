package com.cybersoft.jpabai3.service;

import com.cybersoft.jpabai3.dto.response.CustomerResponse;
import com.cybersoft.jpabai3.entity.CustomerEntity;
import com.cybersoft.jpabai3.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerResponse> findAll() {
        return customerRepository.findAll().stream().map(customerEntity -> {
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setId(customerEntity.getId());
            customerResponse.setName(customerEntity.getName());
            customerResponse.setPhone(customerEntity.getPhone());
            return customerResponse;
        }).toList();
    }
}
