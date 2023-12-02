package br.com.project.usecases.user;

import br.com.project.usecases.port.UserRepository;

public class DeleteUserUseCase {

    private final UserRepository userRepository;

    public DeleteUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean delete(final int id) {

        if (id < 0) {
            return false;
        }

        boolean response = userRepository.deleteById(id);

        return response;
    }

}
