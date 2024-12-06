package br.com.encurtaurl.services;

import br.com.encurtaurl.dtos.RequestUrlDTO;
import br.com.encurtaurl.dtos.UserCreateUrlDTO;
import br.com.encurtaurl.entities.Url;
import br.com.encurtaurl.entities.User;
import br.com.encurtaurl.exceptions.ResourceNotFoundException;
import br.com.encurtaurl.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UrlService urlService;

    @Transactional(readOnly = true)
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public UserCreateUrlDTO createShortUrl(RequestUrlDTO dto , HttpServletRequest request) {
        User user = userRepository.findById(dto.userId()).orElseThrow(()
                -> new ResourceNotFoundException("not found"));
        Url url = new Url(dto);
        url.setUser(user);
        dto = urlService.create(dto,request);
        url.setTinyUrl(dto.tinyUrl());
        user.addUrl(url);
        user = userRepository.save(user);
        return new UserCreateUrlDTO(user);
    }

}
