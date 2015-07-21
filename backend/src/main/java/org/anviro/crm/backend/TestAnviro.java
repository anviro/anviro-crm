package org.anviro.crm.backend;

import org.anviro.crm.backend.authentication.database.entity.Privilege;
import org.anviro.crm.backend.authentication.database.entity.User;
import org.anviro.crm.backend.authentication.database.repository.PrivilegeRepository;
import org.anviro.crm.backend.authentication.database.service.UserService;
import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestAnviro {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        //PrivilegeRepository privilegeRepository = (PrivilegeRepository) context.getBean("privilegeRepository");

        //userService.addUser("Andrey", "Antonina1506", "some@gmail.com", "user", null);
        //userService.updateUser(1l, "someNewPass", null, null);

        String login = "Andrey";
        String password = "someNewPass";

        userService.blockUser(1l);

        authenticateUser(login, password, userService);


    }

    private static void authenticateUser(String login, String password, UserService userService) {
        System.out.println("Trying to authenticate user with name: " + login);
        AuthenticationState state = userService.authenticate(login, password);

        System.out.println("User " + login + " is blocked: " + state.isBlocked());
        System.out.println("Result is: " + state.isSuccessful());
    }

    public static void printUserPrivileges(User user) {
        List<Privilege> privileges = user.getPrivileges();
        System.out.println("User " + user.getUsername() + " privileges");
        for (int i = 0; i < privileges.size(); i++) {
            System.out.println("Privilege: " + privileges.get(i).getType());
        }
    }

}
