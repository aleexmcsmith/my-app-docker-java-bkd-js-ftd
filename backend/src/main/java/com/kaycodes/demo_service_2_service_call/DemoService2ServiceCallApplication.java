package com.kaycodes.demo_service_2_service_call;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication

public class DemoService2ServiceCallApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoService2ServiceCallApplication.class, args);
    }


}
