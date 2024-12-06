package br.com.encurtaurl.dtos.user;

import br.com.encurtaurl.entities.Role;
import br.com.encurtaurl.entities.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public record ResponseUserDTO(Long id, String email , Set<Role> roles) {

    public ResponseUserDTO(User user) {
        this(user.getId(), user.getEmail(), user.getRoles());
    }

}
