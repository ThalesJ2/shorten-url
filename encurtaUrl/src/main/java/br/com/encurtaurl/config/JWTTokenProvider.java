package br.com.encurtaurl.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JWTTokenProvider {

    private static final SecretKey KEY = Keys.hmacShaKeyFor("fskdjfshgbvfnv!$#%#!%"
            .getBytes(StandardCharsets.UTF_8));


    public  static  String GenerateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(KEY)
                .compact();
    }

    public static  boolean validateToken(String token){

    }
}
