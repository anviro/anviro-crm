package org.anviro.crm.backend;

import org.anviro.crm.backend.another.service.DepartmentServiceImpl;
import org.anviro.crm.backend.another.service.EmployeeServiceImpl;
import org.anviro.crm.backend.authentication.service.AuthenticationServiceImpl;
import org.anviro.crm.backend.authentication.service.UserServiceImpl;
import org.anviro.crm.common.webservices.AuthenticationService;
import org.anviro.crm.common.webservices.DepartmentService;
import org.anviro.crm.common.webservices.EmployeeService;
import org.anviro.crm.common.webservices.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class WSConfig {

    @Bean
    public AuthenticationService authenticationService() {
        return new AuthenticationServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public DepartmentService departmentService() {
        return new DepartmentServiceImpl();
    }

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeServiceImpl();
    }

}
