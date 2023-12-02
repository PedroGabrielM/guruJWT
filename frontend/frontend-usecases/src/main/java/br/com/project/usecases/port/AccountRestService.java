package br.com.project.usecases.port;

import br.com.project.domain.UserModel;

public interface AccountRestService {

    UserModel validateCredentialsV1(final String email, final String password);

    UserModel validateCredentialsV2(final String email, final String password);


}
