package br.com.project.implementation.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    @Getter(AccessLevel.NONE)
    private String password;
    private Type type;

    enum Type {
        ADMINISTRATOR,  // 0
        EMPLOYEE,       // 1
        CLIENT          // 2
    }
}
