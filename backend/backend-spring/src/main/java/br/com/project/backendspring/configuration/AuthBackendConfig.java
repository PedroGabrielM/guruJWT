package br.com.project.backendspring.configuration;

import br.com.project.implementation.repository.LoginDAO;
import br.com.project.usecases.authentication.LoginUseCases;
import br.com.project.usecases.port.LoginRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthBackendConfig {

    @Bean
    public LoginUseCases loginUseCases() {
        final LoginRepository loginRepository = new LoginDAO();
        return new LoginUseCases(loginRepository);
    }
}
