package br.com.project.frontendspring.port.impl;

import br.com.project.domain.UserModel;
import br.com.project.usecases.port.AccountRestService;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class AccountRestApiController implements AccountRestService {

    private HttpHeaders getBasicHeaders(final String email, final String password) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("email", email);
        httpHeaders.set("password", password);

        return httpHeaders;
    }

    @Override
    public UserModel validateCredentialsV1(String email, String password) {
        try {
            final RestTemplate restTemplate = new RestTemplate();
            final HttpHeaders httpHeaders = getBasicHeaders(email, password);

            final HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
            final String endpoint = "http://localhost:8081/api/auth/v1/login";
            ResponseEntity<UserModel> responseEntity = restTemplate.exchange(
                    endpoint,
                    HttpMethod.POST,
                    httpEntity,
                    UserModel.class);
            if (responseEntity.getStatusCode() != HttpStatus.OK) {
                return null;
            }
            UserModel user = responseEntity.getBody();
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserModel validateCredentialsV2(String email, String password) {
        try {
            final RestTemplate restTemplate = new RestTemplate();
            final HttpHeaders httpHeaders = getBasicHeaders(email, password);

            final HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
            final String endpoint = "http://localhost:8081/api/auth/v2/login";
            ResponseEntity<UserModel> responseEntity = restTemplate.exchange(
                    endpoint,
                    HttpMethod.POST,
                    httpEntity,
                    UserModel.class);
            if (responseEntity.getStatusCode() != HttpStatus.OK) {
                return null;
            }
            UserModel user = responseEntity.getBody();
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
