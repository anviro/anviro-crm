package org.anviro.crm.common.webservices;

import org.anviro.crm.common.beans.authentication.AuthenticationState;

public interface AuhenticationService {

    AuthenticationState authenticate(String username, String password);

}
