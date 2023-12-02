package br.com.project.backendspring.restcontrollers;

import br.com.project.backendspring.configuration.UserBackendAppConfig;
import br.com.project.domain.UserModel;
import br.com.project.implementation.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserBackendAppConfig userBackendAppConfig = new UserBackendAppConfig();

    @PostMapping("/create")
    public int create(@RequestBody final UserModel userModel) {

        final int id = userBackendAppConfig
                .createUserUseCase()
                .create(userModel);

        return id;

    }

    @GetMapping("/all")
    public List<UserModel> getUsers() {

        List<UserModel> userModels = userBackendAppConfig.findUserUseCase().find();

        return userModels;

    }

    @PutMapping("/update-info")
    public ResponseEntity<Boolean> updateInfo(@RequestBody final UserDTO userDTO) {

        UserModel userModel = userDTO.toUserModel();

        userBackendAppConfig.updateUserUseCase().updateInfo(userDTO.getId(), userModel);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/update-password")
    public ResponseEntity<Boolean> updatePassword(@RequestBody final UserDTO userDTO) {

        UserModel userModel = userDTO.toUserModel();

        userBackendAppConfig.updateUserUseCase().updatePassword(userDTO.getId(), userModel);

        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/remove/{id}")
    public boolean removeById(@PathVariable("id") final int id) {

        final boolean response = userBackendAppConfig.deleteUserUseCase().delete(id);
        return response;

    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable("id") final int id) {

        UserModel userModel = userBackendAppConfig.findUserUseCase().find(id);
        return userModel;

    }

}
