package br.com.encurtaurl.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.TimeZone;

@Entity
public class Url {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 500)
    private String originalUrl;

    @Column(nullable = false , length = 8)
    private String tinyUrl;
    //SELECT ID,EXPIRATION,TINY_URL,ORIGINAL_URL,GetDate() AS 'date_now'  FROM URL  where EXPIRATION >= '2024-11-16 11:00:00' or  EXPIRATION IS NULL;
    @CreationTimestamp
    @Column(columnDefinition = "TIME WITH TIME ZONE")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIME WITH TIME ZONE")
    private Instant updatedAt;

   @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime expiration;

    public Url() {
    }

    public Url(Long id, String originalUrl, String tinyUrl) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.tinyUrl = tinyUrl;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url = (Url) o;
        return Objects.equals(id, url.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
