package br.com.project.frontendspring.configuration;

import br.com.project.frontendspring.port.impl.AccountRestApiController;
import br.com.project.usecases.account.AccountUseCase;
import br.com.project.usecases.port.AccountRestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountFrontendAppConfig {

    @Bean
    public AccountUseCase accountUseCase() {
        final AccountRestService accountRestService = new AccountRestApiController();
        return new AccountUseCase(accountRestService);
    }
}
