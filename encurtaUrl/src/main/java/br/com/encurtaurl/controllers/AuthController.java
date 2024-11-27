package br.com.encurtaurl.controllers;

import br.com.encurtaurl.dtos.JwtAuthResponseDTO;
import br.com.encurtaurl.dtos.LoginDTO;
import br.com.encurtaurl.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<JwtAuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
        String token = authService.login(loginDTO);
        JwtAuthResponseDTO responseDTO = new JwtAuthResponseDTO(token,"Bearer");
        return ResponseEntity.ok(responseDTO);
    }
}
