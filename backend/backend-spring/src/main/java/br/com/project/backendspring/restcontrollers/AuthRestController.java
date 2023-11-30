package br.com.project.backendspring.restcontrollers;

import br.com.project.domain.UserModel;
import br.com.project.usecases.authentication.LoginUseCases;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

    private final LoginUseCases loginUseCases;

    public AuthRestController(LoginUseCases loginUseCases) {
        this.loginUseCases = loginUseCases;
    }

    @PostMapping("/v1/login")
    public UserModel authV1(
            @RequestHeader("email") final String email,
            @RequestHeader("password") final String password) {

        UserModel user = loginUseCases.login(email, password);

        return user;
    }

}
