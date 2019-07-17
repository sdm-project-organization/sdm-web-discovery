package com.mo.discovery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication extends SpringBootServletInitializer {

    @Value("${spring.profiles}")
    String profiles;

    @Value("${server.port}")
    String port;

    @Value("${eureka.instance.hostname}")
    String discovery;

    @PostConstruct
    public void init() {
        System.out.println("profiles : " + profiles);
        System.out.println("port : " + port);
        System.out.println("discovery : " + discovery);
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}