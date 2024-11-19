package br.com.encurtaurl.projections;

import java.time.LocalDateTime;

public interface UrlProjection {
    Long getId();
    String getTinyUrl();
    String getOriginalUrl();
    LocalDateTime getExpiration();
}
