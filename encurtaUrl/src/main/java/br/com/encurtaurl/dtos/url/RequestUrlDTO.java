package br.com.encurtaurl.dtos.url;

import br.com.encurtaurl.entities.Url;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public record RequestUrlDTO(@NotBlank String tinyUrl, @NotBlank String originalUrl , @Future LocalDateTime expiration , Long userId) {


    public RequestUrlDTO(String tinyUrl , String originalUrl , LocalDateTime expiration){
        this(tinyUrl , originalUrl , expiration , 0L);

    }

    public RequestUrlDTO(Url url) {
        this(url.getTinyUrl(), url.getOriginalUrl(), url.getExpiration());
    }
}
