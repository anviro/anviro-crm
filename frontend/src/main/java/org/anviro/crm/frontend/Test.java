package org.anviro.crm.frontend;

import org.anviro.crm.common.beans.another.DepartmentBean;
import org.anviro.crm.common.beans.another.EmployeeBean;
import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.anviro.crm.common.beans.authentication.LogBean;
import org.anviro.crm.common.webservices.AuthenticationService;
import org.anviro.crm.common.webservices.DepartmentService;
import org.anviro.crm.common.webservices.EmployeeService;
import org.anviro.crm.common.webservices.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.bind.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws JAXBException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringWSConfig.class);
        AuthenticationService userService = (AuthenticationService) context.getBean("authenticationService");
        UserService userManagerService = (UserService) context.getBean("userService");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

        for (LogBean log: userService.getLoginLogs()) {
            System.out.println("Log info: ");
            System.out.println(log.getId());
            System.out.println(log.getDate());
            System.out.println(log.getMessage());
        }

    }

}
