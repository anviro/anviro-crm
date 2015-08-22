package org.anviro.crm.common.webservices;

import org.anviro.crm.common.beans.authentication.AuthenticationState;

import javax.jws.WebService;

@WebService
public interface AuthenticationService extends AbstractService {

    AuthenticationState authenticate(String username, String password);

}
