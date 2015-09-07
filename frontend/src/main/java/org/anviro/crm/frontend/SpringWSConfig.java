package org.anviro.crm.frontend;

import org.anviro.crm.common.webservices.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@ComponentScan
public class SpringWSConfig {

    private static final String WSDL_LOCATION = "http://localhost:9999/{?}?wsdl";
    private static final String SERVICE_URI = "http://service.{?}.backend.crm.anviro.org/";

    @Bean
    public AuthenticationService authenticationService() {
        return (AuthenticationService) createService("authentication", "AuthenticationService", AuthenticationService.class);
    }

    @Bean
    public UserService userService() {
        return (UserService) createService("authentication", "UserService", UserService.class);
    }

    @Bean
    public EmployeeService employeeService() {
        return (EmployeeService) createService("another", "EmployeeService", EmployeeService.class);
    }

    @Bean
    public DepartmentService departmentService() {
        return (DepartmentService) createService("another", "DepartmentService", DepartmentService.class);
    }

    private AbstractService createService(String packageName, String serviceName, Class<?> clazz) {
        String serviceWSDL = WSDL_LOCATION.replace("{?}", serviceName);
        URL url = null;
        try {
            url = new URL(serviceWSDL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName qname = new QName(SERVICE_URI.replace("{?}", packageName), serviceName);

        Service service = Service.create(url, qname);
        AbstractService abstractService = (AbstractService) service.getPort(clazz);

        return abstractService;
    }

}
