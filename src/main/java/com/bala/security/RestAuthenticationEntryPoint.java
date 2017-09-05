package com.bala.security;
 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
 

@Component
public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
 
    @Override
    public void commence(HttpServletRequest arg0, HttpServletResponse response,
            AuthenticationException arg2) throws IOException, ServletException {
    	response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + arg2.getMessage());
 
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("testing rest serice");
        super.afterPropertiesSet();
    }
}