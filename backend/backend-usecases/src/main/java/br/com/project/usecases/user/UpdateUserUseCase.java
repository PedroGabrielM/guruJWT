package br.com.project.usecases.user;

import br.com.project.domain.UserModel;
import br.com.project.usecases.port.PasswordEncoder;
import br.com.project.usecases.port.UserRepository;

public class UpdateUserUseCase {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UpdateUserUseCase(UserRepository userRepository,
                             PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserModel updateInfo(final int id, final UserModel userModel) {

        if (userModel == null || id < 0) {
            return null;
        }

        UserModel userToBeUpdated = userRepository.findById(id);

        if (userToBeUpdated == null) {
            return null;
        }

        if (userModel.getEmail().isEmpty()) {
            return null;
        }

        userToBeUpdated.setEmail(userModel.getEmail());

        final boolean response = userRepository.update(userToBeUpdated);

        if (response == false) {
            return null;
        }

        return userToBeUpdated;
    }

    public boolean updatePassword(final int id, final UserModel entity) {

        if (entity == null || entity.getPassword() == null || entity.getPassword().isEmpty() || entity.getPassword().length() < 4) {
            return false;
        }

        UserModel userById = userRepository.findById(id);

        userById.setPassword(entity.getPassword());
        final boolean response = userRepository.updatePassword(id, userById);
        return response;
    }
}
