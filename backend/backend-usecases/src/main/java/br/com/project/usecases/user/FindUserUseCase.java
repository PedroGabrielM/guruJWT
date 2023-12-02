package br.com.project.usecases.user;

import br.com.project.domain.UserModel;
import br.com.project.usecases.exception.InvalidIdException;
import br.com.project.usecases.exception.NotFoundException;
import br.com.project.usecases.port.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindUserUseCase {

    private final UserRepository userRepository;

    public FindUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel find(final int id) {

        if (id < 0) {
            throw new InvalidIdException();
        }

        UserModel user = userRepository.findById(id);

        if (user == null) {
            final String message = "O id " + id + " nao foi encontrado";
            throw new NotFoundException(message);
        }

        return user;
    }

    public List<UserModel> find() {

        List<UserModel> users = userRepository.findAll();

        if (users == null) {
            return new ArrayList<>();
        }

        return users;
    }

    public List<UserModel> find(final Map<String, String> criteria) {

        if (criteria == null) {
            return null;
        }

        if (criteria.size() == 0) {
            return find();
        }

        final List<UserModel> byCriteria = userRepository.findByCriteria(criteria);

        return byCriteria;
    }
}
