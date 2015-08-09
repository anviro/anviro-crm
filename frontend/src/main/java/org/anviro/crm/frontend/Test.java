package org.anviro.crm.frontend;

import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.anviro.crm.common.webservices.AuthenticationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringWSConfig.class);
        AuthenticationService userService = (AuthenticationService) context.getBean("authenticationService");
        AuthenticationState state = userService.authenticate("Andrey", "someNewPass");
        System.out.println(state.isBlocked());
    }

}
