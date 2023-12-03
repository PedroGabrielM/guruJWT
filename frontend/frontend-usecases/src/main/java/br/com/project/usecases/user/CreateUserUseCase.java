package br.com.project.usecases.user;

import br.com.project.domain.UserModel;
import br.com.project.domain.helper.StringHelper;
import br.com.project.usecases.port.RestService;

public class CreateUserUseCase {

    private final RestService<UserModel> restService;

    private final StringHelper stringHelper;

    public CreateUserUseCase(RestService<UserModel> restService, StringHelper stringHelper) {
        this.restService = restService;
        this.stringHelper = stringHelper;
    }

    public UserModel create(final UserModel userModel) {

        if (stringHelper.isNullOrEmpty(userModel.getEmail())
                || stringHelper.isNullOrEmpty(userModel.getPassword())) {
            return null;
        }

        final String resource = "/user/create";
        final int id = restService.post(resource, userModel);
        userModel.setId(id);
        return userModel;
    }
}
