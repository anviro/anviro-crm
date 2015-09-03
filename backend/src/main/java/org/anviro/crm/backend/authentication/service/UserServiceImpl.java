package org.anviro.crm.backend.authentication.service;

import org.anviro.crm.backend.authentication.database.service.UserDBService;
import org.anviro.crm.common.beans.authentication.UserBean;
import org.anviro.crm.common.webservices.UserService;
import org.anviro.crm.common.webservices.WebServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "org.anviro.crm.common.webservices.UserService",
        serviceName = WebServiceConstants.USER_SERVICE_NAME)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDBService userDBService;

    @Override
    public List<UserBean> getUsers() {
        return userDBService.getUsers();
    }

    @Override
    public UserBean getUser(Long id) {
        return userDBService.getUser(id);
    }

    @Override
    public boolean addUser(String username, String password, String email, List<String> roles) {
        return userDBService.addUser(username, password, email, roles);
    }

    @Override
    public boolean updateUser(Long userId, String password, String email, List<String> roles) {
        return userDBService.updateUser(userId, password, email, roles);
    }

    @Override
    public boolean removeUser(Long userId) {
        return userDBService.removeUser(userId);
    }

    @Override
    public boolean blockUser(Long userId) {
        return userDBService.blockUser(userId);
    }
}
