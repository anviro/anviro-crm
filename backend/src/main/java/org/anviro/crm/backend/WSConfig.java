package org.anviro.crm.backend;

import org.anviro.crm.backend.authentication.service.AuthenticationServiceImpl;
import org.anviro.crm.backend.authentication.service.AuthenticationServiceImpl2;
import org.anviro.crm.common.webservices.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class WSConfig {

    @Bean
    public AuthenticationService authenticationService() {
        return new AuthenticationServiceImpl2();
    }

}
