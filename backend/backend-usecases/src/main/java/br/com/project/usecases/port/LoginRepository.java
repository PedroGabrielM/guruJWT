package br.com.project.usecases.port;

import br.com.project.domain.UserModel;

public interface LoginRepository {
    UserModel login(final String email, final String password);

}
