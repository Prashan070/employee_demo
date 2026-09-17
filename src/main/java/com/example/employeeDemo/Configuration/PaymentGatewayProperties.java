package com.example.employeeDemo.Configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties( prefix = "payment-gateway")
public class PaymentGatewayProperties {


    private String type;
    private int retryCount;
    private int timeout;

}
