package org.anviro.crm.backend.another.database.service;

import org.anviro.crm.backend.another.database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDBService {

    @Autowired
    private EmployeeRepository employeeRepository;



}
