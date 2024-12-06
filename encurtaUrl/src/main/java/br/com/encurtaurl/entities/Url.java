package br.com.encurtaurl.entities;

import br.com.encurtaurl.dtos.RequestUrlDTO;
import br.com.encurtaurl.dtos.UrlProjectionDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity

public class Url {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 500)
    private String originalUrl;

    @Column(nullable = false , length = 8)
    private String tinyUrl;

    @CreationTimestamp
    @Column(columnDefinition = "TIME WITH TIME ZONE")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(columnDefinition = "TIME WITH TIME ZONE")
    private Instant updatedAt;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime expiration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Url() {
    }

    public Url(Long id, String originalUrl, String tinyUrl) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.tinyUrl = tinyUrl;

    }

    public Url(UrlProjectionDTO dto){
        originalUrl = dto.originalUrl();
        tinyUrl = dto.tinyUrl();
        expiration = dto.expiration();
    }
    public Url(RequestUrlDTO dto){
        originalUrl = dto.originalUrl();
        tinyUrl = dto.tinyUrl();
        expiration = dto.expiration();
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


    public void setUser(User user) {
        this.user = user;
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
