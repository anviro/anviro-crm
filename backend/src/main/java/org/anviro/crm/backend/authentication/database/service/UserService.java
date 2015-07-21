package org.anviro.crm.backend.authentication.database.service;

import org.anviro.crm.backend.authentication.database.entity.Privilege;
import org.anviro.crm.backend.authentication.database.entity.User;
import org.anviro.crm.backend.authentication.database.repository.UserRepository;
import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
            }
        } else {
            if (user.isBlocked()) {
                authState.setBlocked(true);
            }
        }

        return authState;
    }

    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public boolean addUser(String username, String password, String email,
                        String role, List<Privilege> privileges) {
        boolean result = false;
        User user = userRepository.findOneByUsername(username);

        if (user == null) {
            User newUser = new User(username, password, email, role, privileges);
            userRepository.save(newUser);
            result = true;
        }

        return result;
    }

    @Transactional
    public void updateUser(Long userId, String password, String email, List<Privilege> privileges) {
        User existingUser = userRepository.findOne(userId);
        existingUser.setPassword(password);
        existingUser.setEmail(email);
        existingUser.setPrivileges(privileges);
    }

    public void removeUser(Long id) {
        userRepository.delete(id);
    }

    @Transactional
    public void blockUser(Long id) {
        User user = userRepository.findOne(id);
        user.setBlocked(true);
    }

}
