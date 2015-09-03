package org.anviro.crm.backend;

import org.anviro.crm.backend.another.database.entity.Department;
import org.anviro.crm.common.beans.another.DepartmentBean;
import org.anviro.crm.common.webservices.AuthenticationService;
import org.anviro.crm.common.webservices.DepartmentService;
import org.anviro.crm.common.webservices.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.ws.Endpoint;

public class TestAnviro {

    private static final String WS_AUTH_URL = "http://localhost:9999/AuthenticationService";
    private static final String WS_USER_URL = "http://localhost:9999/UserService";
    private static final String WS_DEPARTMENT_URL = "http://localhost:9999/DepartmentService";

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class, WSConfig.class);
        AuthenticationService userService = (AuthenticationService) context.getBean("authenticationService");
        UserService userManagerService = (UserService) context.getBean("userService");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");

        Endpoint.publish(WS_AUTH_URL, userService);
        Endpoint.publish(WS_USER_URL, userManagerService);
        Endpoint.publish(WS_DEPARTMENT_URL, departmentService);

        DepartmentBean departmentBean = new DepartmentBean("Petrovka", "London", "8888");
        departmentService.addDepartment(departmentBean);
    }

}
