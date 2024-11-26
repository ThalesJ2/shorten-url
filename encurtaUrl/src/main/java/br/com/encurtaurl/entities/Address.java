package br.com.encurtaurl.entities;

import jakarta.persistence.Column;

public class Address {

    private String city;
    private String region;
    private String country;

    @Column(name = "timeZone")
    private String timezone;


    public Address() {
    }

    public Address(String city, String region, String country, String timezone) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.timezone = timezone;
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
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", timeZone='" + timezone + '\'' +
                '}';
    }
}
