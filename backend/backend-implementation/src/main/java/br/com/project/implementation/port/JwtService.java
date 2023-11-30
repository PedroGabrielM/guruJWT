package br.com.project.implementation.port;


import br.com.project.domain.UserModel;

public interface JwtService {

    String getJwtToken(final UserModel user);
}
