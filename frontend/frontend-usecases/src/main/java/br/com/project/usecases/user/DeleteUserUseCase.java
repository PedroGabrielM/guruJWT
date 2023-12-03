package br.com.project.usecases.user;

import br.com.project.domain.UserModel;
import br.com.project.usecases.port.RestService;

public class DeleteUserUseCase {

    private final RestService<UserModel> restService;

    public DeleteUserUseCase(RestService<UserModel> restService) {
        this.restService = restService;
    }

    public boolean deleteById(final int id) {

        final String resource = "/user/remove/" + id;

        return restService.delete(resource);
    }
}
