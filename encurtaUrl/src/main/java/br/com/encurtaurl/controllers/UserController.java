package br.com.encurtaurl.controllers;

import br.com.encurtaurl.dtos.RequestUrlDTO;
import br.com.encurtaurl.dtos.user.RequestUserDTO;
import br.com.encurtaurl.dtos.user.ResponseUserDTO;
import br.com.encurtaurl.dtos.user.UserCreateUrlDTO;
import br.com.encurtaurl.entities.User;
import br.com.encurtaurl.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<ResponseUserDTO> create(@RequestBody RequestUserDTO requestUserDTO){
        return ResponseEntity.ok(userService.create(requestUserDTO));
    }

    @PostMapping("/urls")
    public ResponseEntity<UserCreateUrlDTO> createShortUrl(@RequestBody RequestUrlDTO urlDTO, HttpServletRequest request){
        return ResponseEntity.ok(userService.createShortUrl(urlDTO,request));
    }


}
