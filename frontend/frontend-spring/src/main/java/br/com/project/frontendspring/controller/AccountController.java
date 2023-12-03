package br.com.project.frontendspring.controller;

import br.com.project.usecases.account.AccountUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountUseCase accountUseCase;

    public AccountController(AccountUseCase accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "/account/login";
    }

    @GetMapping("/orders")
    public String getOrdersPage() {
        return "/account/my-orders";
    }

    @GetMapping("/profile")
    public String getProfilePage() {
        return "/account/my-profile";
    }

}
