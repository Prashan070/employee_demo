package com.example.employeeDemo.Configuration.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;


public class TimingInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest httpServletRequest,
                             @NonNull HttpServletResponse httpServletResponse,
                             @NonNull Object handler) {
        httpServletRequest.setAttribute("startTime", System.currentTimeMillis());
        System.out.println("Interceptor: before controller method runs");

        return true;
    }


    public void afterCompletion(HttpServletRequest request,
                                @NonNull HttpServletResponse response,
                                @NonNull Object handler,
                                Exception ex) {

        long startTime = (Long) request.getAttribute("startTime");
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Interceptor: request took " + duration + "ms");

    }


}
