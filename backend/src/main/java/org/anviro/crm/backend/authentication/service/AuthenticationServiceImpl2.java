package org.anviro.crm.backend.authentication.service;

import org.anviro.crm.backend.authentication.database.service.UserService;
import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.anviro.crm.common.webservices.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

@WebService(endpointInterface = "org.anviro.crm.common.webservices.AuthenticationService",
        serviceName = "AuthenticationServiceImplService")
public class AuthenticationServiceImpl2 implements AuthenticationService{

    @Autowired
    private UserService userService;

    public AuthenticationState authenticate(String username, String password) {
        return userService.authenticate(username, password);
    }

}
