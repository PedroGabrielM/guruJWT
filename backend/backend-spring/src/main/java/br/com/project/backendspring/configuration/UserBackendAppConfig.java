package br.com.project.backendspring.configuration;

import br.com.project.implementation.repository.UserDAO;
import br.com.project.usecases.port.UserRepository;
import br.com.project.usecases.user.CreateUserUseCase;
import br.com.project.usecases.user.DeleteUserUseCase;
import br.com.project.usecases.user.FindUserUseCase;
import br.com.project.usecases.user.UpdateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBackendAppConfig {

    private final UserRepository userRepository;

    public UserBackendAppConfig() {
        this.userRepository = new UserDAO();
    }

    @Bean
    public CreateUserUseCase createUserUseCase() {
        return new CreateUserUseCase(userRepository);
    }

    @Bean
    public FindUserUseCase findUserUseCase() {
        return new FindUserUseCase(userRepository);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase() {
        return new UpdateUserUseCase(userRepository, null);
    }

    @Bean
    public DeleteUserUseCase deleteUserUseCase() {
        return new DeleteUserUseCase(userRepository);
    }

}
