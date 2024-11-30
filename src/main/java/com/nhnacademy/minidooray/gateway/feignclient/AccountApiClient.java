package com.nhnacademy.minidooray.gateway.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "accountApi", url = "http://localhost:8081")
public interface AccountApiClient {
    @GetMapping("/account/{userId}")
    AccountResponse getAccount(@PathVariable("userId") String userId);
}
