package br.com.project.usecases.port;

public interface PasswordEncoder {

    String encode(final String password);
}
