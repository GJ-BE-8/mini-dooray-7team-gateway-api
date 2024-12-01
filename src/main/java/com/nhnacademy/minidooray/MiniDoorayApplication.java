package com.nhnacademy.minidooray;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.minidooray.gateway.feignclient.AccountApiClient;
import com.nhnacademy.minidooray.gateway.feignclient.TaskApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableFeignClients
@EnableTransactionManagement
@EnableRedisHttpSession
@Slf4j
public class MiniDoorayApplication {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    AccountApiClient accountApiClient;
    @Autowired
    TaskApiClient taskApiClient;

    public static void main(String[] args) {
        SpringApplication.run(MiniDoorayApplication.class, args);
    }

}
