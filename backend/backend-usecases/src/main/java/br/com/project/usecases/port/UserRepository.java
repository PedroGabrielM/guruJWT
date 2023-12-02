package br.com.project.usecases.port;

import br.com.project.domain.UserModel;

import java.util.List;
import java.util.Map;

public interface UserRepository {

    int create(final UserModel userModel);

    UserModel findById(final int id);

    List<UserModel> findAll();

    List<UserModel> findByCriteria(final Map<String, String> criteria);

    boolean update(final UserModel userModel);

    boolean updatePassword(final int id, final UserModel userModel);

    boolean deleteById(final int id);
}
