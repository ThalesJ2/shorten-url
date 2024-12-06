package br.com.encurtaurl.dtos.url;

import br.com.encurtaurl.projections.UrlProjection;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UrlProjectionDTO(Long id , @NotBlank String tinyUrl, @NotBlank String originalUrl , @Future LocalDateTime expiration) {

    public UrlProjectionDTO(UrlProjection projection) {
        this(projection.getId(),projection.getTinyUrl(),projection.getOriginalUrl(),projection.getExpiration());
    }
}
