package com.example.employeeDemo.Configuration.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        System.out.println("Incoming request" +
                httpServletRequest.getMethod() +
                " " +
                httpServletRequest.getRequestURI() +
                " " +
                httpServletRequest.getHeader("Token"));


        chain.doFilter(servletRequest, servletResponse);


        System.out.println("Incoming respone" +
                httpServletResponse.getStatus());

    }
}
