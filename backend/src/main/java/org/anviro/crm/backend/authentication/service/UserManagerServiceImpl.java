package org.anviro.crm.backend.authentication.service;

import org.anviro.crm.backend.authentication.database.service.UserService;
import org.anviro.crm.common.beans.authentication.UserInfo;
import org.anviro.crm.common.webservices.UserManagerService;
import org.anviro.crm.common.webservices.WebServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "org.anviro.crm.common.webservices.UserManagerService",
        serviceName = WebServiceConstants.USER_MANAGER_SERVICE_NAME)
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    private UserService userService;

    @Override
    public List<UserInfo> getUsers() {
        return userService.getUsers();
    }

    @Override
    public UserInfo getUser(Long id) {
        return userService.getUser(id);
    }

    @Override
    public boolean addUser(String username, String password, String email, List<String> roles) {
        return userService.addUser(username, password, email, roles);
    }

    @Override
    public boolean updateUser(Long userId, String password, String email, List<String> roles) {
        return userService.updateUser(userId, password, email, roles);
    }

    @Override
    public boolean removeUser(Long userId) {
        return userService.removeUser(userId);
    }

    @Override
    public boolean blockUser(Long userId) {
        return userService.blockUser(userId);
    }
}
