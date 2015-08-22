package org.anviro.crm.frontend;

import org.anviro.crm.common.beans.authentication.AuthenticationState;
import org.anviro.crm.common.beans.authentication.UserInfo;
import org.anviro.crm.common.webservices.AuthenticationService;
import org.anviro.crm.common.webservices.UserManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.bind.*;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {



    public static void main(String[] args) throws JAXBException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringWSConfig.class);
        AuthenticationService userService = (AuthenticationService) context.getBean("authenticationService");
        UserManagerService userManagerService = (UserManagerService) context.getBean("userManagerService");

       /* List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("user");

        boolean res = userManagerService.addUser("Noname", "2828", "@.com", roles);
        System.out.println(res);*/

        AuthenticationState state = userService.authenticate("Noname", "2828");
        System.out.println(state.isSuccessful());



        System.out.println("Roles are: " + "\n");
        for(String role : state.getRoles()) {
            System.out.println(role);
        }



    }

}
