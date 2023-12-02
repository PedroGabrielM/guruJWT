package br.com.project.implementation.dto;

import br.com.project.domain.UserModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private int id;
    private String email;
    private String password;
    private Type type;

    enum Type {
        ADMINISTRATOR,  // 0
        EMPLOYEE,       // 1
        CLIENT          // 2
    }

    public UserModel toUserModel() {
        final UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setPassword(password);
        userModel.setEmail(email);
        userModel.setType(UserModel.Type.CLIENT);

        return userModel;
    }
}
