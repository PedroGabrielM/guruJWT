package br.com.project.usecases.user;

import br.com.project.domain.UserModel;
import br.com.project.usecases.port.UserRepository;

public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int create(final UserModel userToBeCreated) {

        if (userToBeCreated == null) {
            return -1;
        }

        if (userToBeCreated.getPassword().isEmpty()
                || userToBeCreated.getEmail().isEmpty()) {
            return -1;
        }

        if (userToBeCreated.getPassword().length() < 4) {
            return -1;
        }

        final int userId = userRepository.create(userToBeCreated);

        if (userId < 0) {
            return -1;
        }

        return userId;
    }

}
