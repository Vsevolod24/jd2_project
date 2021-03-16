package it.academy.security;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebSensorSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public WebSensorSecurityInitializer(){
        super(WebSensorSecurityConfiguration.class);
    }

}