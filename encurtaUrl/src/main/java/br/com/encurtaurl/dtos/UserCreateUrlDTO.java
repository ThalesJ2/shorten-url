package br.com.encurtaurl.dtos;

import br.com.encurtaurl.entities.Url;
import br.com.encurtaurl.entities.User;

import java.util.Set;

public record UserCreateUrlDTO(Long id, String email, Set<Url> urls) {

    public UserCreateUrlDTO(User user) {
        this(user.getId(), user.getEmail(), user.getUrls());
    }
}
