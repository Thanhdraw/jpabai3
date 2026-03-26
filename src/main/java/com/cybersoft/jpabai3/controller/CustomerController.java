package com.cybersoft.jpabai3.controller;

import com.cybersoft.jpabai3.dto.response.CustomerResponse;
import com.cybersoft.jpabai3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService  customerService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
}
