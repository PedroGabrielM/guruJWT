package br.com.project.usecases.account;

import br.com.project.domain.UserModel;
import br.com.project.usecases.port.AccountRestService;

public class AccountUseCase {

    private final AccountRestService accountRestService;

    public AccountUseCase(AccountRestService accountRestService) {
        this.accountRestService = accountRestService;
    }

    public UserModel login(final String email,
                           final String password) {
        if (email == null
                || !email.contains("@")) {
            return null;
        }

        if (password == null
                || password.length() < 4) {
            return null;
        }

        UserModel userModel = accountRestService
                .validateCredentialsV2(email, password);

        return userModel;
    }
}
