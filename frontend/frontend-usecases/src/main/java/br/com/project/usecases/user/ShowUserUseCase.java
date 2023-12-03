package br.com.project.usecases.user;

import br.com.project.domain.UserModel;
import br.com.project.usecases.port.RestService;

import java.util.List;

public class ShowUserUseCase {

    private final RestService<UserModel> restService;

    public ShowUserUseCase(RestService<UserModel> restService) {
        this.restService = restService;
    }

    public List<UserModel> showAllUsers() {
        final String resource = "/user/all";
        final List<UserModel> userModels = restService.get(resource);
        return userModels;
    }

    public UserModel showUserById(final int id, final String token) {
        final String resource = "/user/" + id;
        return restService.getById(resource, UserModel.class);
    }
}
