package com.cybersoft.jpabai3.controller;

import com.cybersoft.jpabai3.entity.employee.EmployeeEntity;
import com.cybersoft.jpabai3.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Page<EmployeeEntity>> getAllEmployees(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(employeeService.getAllEmployees(pageable));
    }
}
