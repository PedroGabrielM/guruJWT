package br.com.project.frontendspring.dto;


import br.com.project.domain.UserModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String fullName;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;

    public UserModel toUserModel() {
        final UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setPassword(password);
        userModel.setEmail(email);
        userModel.setType(UserModel.Type.CLIENT);

        return userModel;
    }
}
