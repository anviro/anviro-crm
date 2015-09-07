package org.anviro.crm.backend.authentication.service;

import org.anviro.crm.backend.authentication.database.service.LogDBService;
import org.anviro.crm.backend.authentication.database.service.UserDBService;
import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.anviro.crm.common.beans.authentication.LogBean;
import org.anviro.crm.common.webservices.AuthenticationService;
import org.anviro.crm.common.webservices.WebServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "org.anviro.crm.common.webservices.AuthenticationService",
        serviceName = WebServiceConstants.AUTH_SERVICE_NAME)
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserDBService userDBService;

    @Autowired
    private LogDBService logDBService;

    public AuthenticationState authenticate(String username, String password) {
        return userDBService.authenticate(username, password);
    }

    @Override
    public List<LogBean> getLoginLogs() {
        return logDBService.getLoginLogs();
    }
}
