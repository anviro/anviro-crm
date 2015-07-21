package org.anviro.crm.backend.authentication.service;

import org.anviro.crm.backend.authentication.database.service.UserService;
import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.anviro.crm.common.webservices.AuhenticationService;

public class AuthenticationServiceImpl implements AuhenticationService {

    private UserService userService;

    public AuthenticationState authenticate(String username, String password) {
        return userService.authenticate(username, password);
    }
}
