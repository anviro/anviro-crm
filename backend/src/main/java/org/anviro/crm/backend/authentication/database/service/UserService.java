package org.anviro.crm.backend.authentication.database.service;

import org.anviro.crm.backend.authentication.Utils;
import org.anviro.crm.backend.authentication.database.entity.User;
import org.anviro.crm.backend.authentication.database.repository.UserRepository;
import org.anviro.crm.common.beans.authentication.AuthenticationState;;
import org.anviro.crm.common.beans.authentication.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public AuthenticationState authenticate(String username, String password) {
        User user = userRepository.findOneByUsername(username);
        AuthenticationState authState = new AuthenticationState();

        if (user == null) {
            return authState;
        }

        if (!user.isBlocked()) {
            if (user.getPassword().equals(password)) {
                authState.setSuccessful(true);
                authState.setRoles(user.getRoles());
            }
        } else {
            if (user.isBlocked()) {
                authState.setBlocked(true);
            }
        }

        return authState;
    }

    public UserInfo getUser(Long id) {
        return Utils.createUserInfo(userRepository.findOne(id));
    }

    public List<UserInfo> getUsers() {
        List<User> dbUsers = userRepository.findAll();
        List<UserInfo> users = new ArrayList<>();
        for (User user: dbUsers) {
            users.add(Utils.createUserInfo(user));
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
