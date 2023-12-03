package br.com.project.frontendspring.configuration;

import br.com.project.usecases.account.AccountUseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountFrontendAppConfig {

    public AccountUseCase accountUseCase() {
        return null;
    }
}
