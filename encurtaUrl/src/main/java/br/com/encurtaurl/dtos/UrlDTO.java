package br.com.encurtaurl.dtos;

import br.com.encurtaurl.projections.UrlProjection;

import java.time.LocalDateTime;

public record UrlDTO(Long id ,String tinyUrl, String originalUrl , LocalDateTime expiration) {

    public UrlDTO(UrlProjection projection) {
        this(projection.getId(),projection.getTinyUrl(),projection.getOriginalUrl(),projection.getExpiration());
    }
}
