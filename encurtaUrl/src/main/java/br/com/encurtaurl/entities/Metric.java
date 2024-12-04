package br.com.encurtaurl.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Metric {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long click;

    private String city;
    private String region;
    private String country;

    @Column(name = "timeZone")
    private String timezone;

    public Metric() {
    }

    public Metric(String city, String region, String country, String timezone) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.timezone = timezone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClick() {
        return click;
    }

    public void setClick(Long click) {
        this.click = click;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metric metric = (Metric) o;
        return Objects.equals(id, metric.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
