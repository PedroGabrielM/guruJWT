package br.com.project.usecases.user;

import br.com.project.domain.UserModel;
import br.com.project.usecases.port.RestService;

public class UpdateUserUseCase {

    private final RestService<UserModel> restService;

    public UpdateUserUseCase(RestService<UserModel> restService) {
        this.restService = restService;
    }

    public boolean updateInfo(final UserModel userModel) {
        if (userModel == null || userModel.getEmail().isEmpty()) {
            return false;
        }

        final String resource = "/user/update-info";

        final boolean response = restService.put(resource, userModel);

        return response;
    }

    public boolean updatePassword(final UserModel userModel) {
        if (userModel == null || userModel.getPassword().isEmpty()) {
            return false;
        }

        final String resource = "/user/update-password";
        final boolean response = restService.put(resource, userModel);

        return response;
    }
}
