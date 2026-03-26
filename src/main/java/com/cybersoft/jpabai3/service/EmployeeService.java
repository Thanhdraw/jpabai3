package com.cybersoft.jpabai3.service;

import com.cybersoft.jpabai3.entity.employee.EmployeeEntity;
import com.cybersoft.jpabai3.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Page<EmployeeEntity> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}
