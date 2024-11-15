package br.com.encurtaurl.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Url {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 500)
    private String originalUrl;

    @Column(nullable = false , length = 8)
    private String tinyUrl;


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
