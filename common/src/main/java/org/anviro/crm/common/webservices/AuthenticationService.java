package org.anviro.crm.common.webservices;

import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.anviro.crm.common.beans.authentication.LogBean;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface AuthenticationService extends AbstractService {

    AuthenticationState authenticate(String username, String password);

    List<LogBean> getLoginLogs();

}
