package br.com.project.usecases.authentication;

import br.com.project.domain.UserModel;
import br.com.project.usecases.port.LoginRepository;

public class LoginUseCases {

    private final LoginRepository loginRepository;

    public LoginUseCases(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public UserModel login(final String email,
                           final String password) {

        if (email.isEmpty()
                || password.isEmpty()) {
            return null;
        }

        final UserModel user = loginRepository.login(email, password);
        if (user != null) {
            user.setPassword("");
        }

        return user;
    }

}
