package org.anviro.crm.frontend;

import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.anviro.crm.common.webservices.AuthenticationService;
import org.anviro.crm.common.webservices.AbstractService;
import org.anviro.crm.common.webservices.UserManagerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
public class SpringWSConfig {

    private static final String WSDL_LOCATION = "http://localhost:9999/{?}?wsdl";
    private static final String SERVICE_URI = "http://service.authentication.backend.crm.anviro.org/";

    @Bean
    public AuthenticationService authenticationService() {
        return (AuthenticationService) createService("AuthenticationService", AuthenticationService.class);
    }

    @Bean
    public UserManagerService userManagerService() {
        return (UserManagerService) createService("UserManagerService", UserManagerService.class);
    }


    private AbstractService createService(String serviceName, Class<?> clazz) {
        String serviceWSDL = WSDL_LOCATION.replace("{?}", serviceName);
        URL url = null;
        try {
            url = new URL(serviceWSDL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName qname = new QName(SERVICE_URI, serviceName);

        Service service = Service.create(url, qname);
        AbstractService abstractService = (AbstractService) service.getPort(clazz);

        return abstractService;
    }

}
