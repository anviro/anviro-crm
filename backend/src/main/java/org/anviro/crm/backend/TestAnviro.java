package org.anviro.crm.backend;

import org.anviro.crm.backend.authentication.database.entity.User;
import org.anviro.crm.backend.authentication.database.service.UserService;
import org.anviro.crm.backend.authentication.service.AuthenticationServiceImpl;
import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.anviro.crm.common.webservices.AuthenticationService;
import org.anviro.crm.common.webservices.UserManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.ws.Endpoint;
import java.util.List;

public class TestAnviro {

    private static final String WS_AUTH_URL = "http://localhost:9999/AuthenticationService";
    private static final String WS_USER_MANAGER_URL = "http://localhost:9999/UserManagerService";

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class, WSConfig.class);
        AuthenticationService userService = (AuthenticationService) context.getBean("authenticationService");
        UserManagerService userManagerService = (UserManagerService) context.getBean("userManagerService");

        Endpoint.publish(WS_AUTH_URL, userService);
        Endpoint.publish(WS_USER_MANAGER_URL, userManagerService);
    }

}
