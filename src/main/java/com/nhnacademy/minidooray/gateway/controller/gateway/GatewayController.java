package com.nhnacademy.minidooray.gateway.controller.gateway;

import com.nhnacademy.minidooray.gateway.domain.member.request.register.MemberCreateDto;
import com.nhnacademy.minidooray.gateway.service.account.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GatewayController {

    private AccountService accountService;

    public GatewayController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public String registerUser(@PathVariable
                               @RequestBody MemberCreateDto memberCreateDto
                               ) {
        accountService.registerUser(memberCreateDto);

        return "regiter";
    }
}
