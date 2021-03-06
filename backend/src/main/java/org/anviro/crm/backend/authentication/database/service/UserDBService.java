package org.anviro.crm.backend.authentication.database.service;

import org.anviro.crm.backend.authentication.Utils;
import org.anviro.crm.backend.authentication.database.entity.Log;
import org.anviro.crm.backend.authentication.database.entity.User;
import org.anviro.crm.backend.authentication.database.repository.UserRepository;
import org.anviro.crm.common.beans.authentication.AuthenticationState;;
import org.anviro.crm.common.beans.authentication.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDBService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogDBService logDBService;

    public AuthenticationState authenticate(String username, String password) {
        User user = userRepository.findOneByUsername(username);
        AuthenticationState authState = new AuthenticationState();
        Log log = new Log(new Date(), username);

        if (user == null) {
            log.setMessage("User \"" + username + "\" tried to enter the system. Such user doesn`t exist!");
            logDBService.addLoginLog(log);
            return authState;
        }

        if (!user.isBlocked()) {
            if (user.getPassword().equals(password)) {
                authState.setSuccessful(true);
                authState.setRoles(user.getRoles());
                log.setMessage("User \"" + username + "\" successfully entered the system!");
            }
        } else {
            if (user.isBlocked()) {
                authState.setBlocked(true);
                log.setMessage("User \"" + username + "\" tried to enter the system, but the user is blocked!");
            }
        }

        logDBService.addLoginLog(log);

        return authState;
    }

    public UserBean getUser(Long id) {
        return Utils.createUserBean(userRepository.findOne(id));
    }

    public List<UserBean> getUsers() {
        List<User> dbUsers = userRepository.findAll();
        List<UserBean> users = new ArrayList<>();
        for (User user: dbUsers) {
            users.add(Utils.createUserBean(user));
        }
        return users;
    }

    @Transactional
    public boolean addUser(String username, String password, String email,
                        List<String> roles) {
        User user = userRepository.findOneByUsername(username);

        if (user == null) {
            User newUser = new User(username, password, email, roles);
            userRepository.save(newUser);
            return true;
        }

        return false;
    }

    @Transactional
    public boolean updateUser(Long userId, String password, String email, List<String> roles) {
        User existingUser = userRepository.findOne(userId);

        existingUser.setPassword(password);
        existingUser.setEmail(email);
        existingUser.setRoles(roles);

        return true;
    }

    public boolean removeUser(Long id) {
        userRepository.delete(id);
        return true;
    }

    @Transactional
    public boolean blockUser(Long id) {
        User user = userRepository.findOne(id);
        user.setBlocked(true);
        return true;
    }

}
