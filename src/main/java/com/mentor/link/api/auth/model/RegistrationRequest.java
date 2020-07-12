package com.mentor.link.api.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationRequest {

    private final String name;
    private final String email;
    private final String password;
    private final String city;
    private final String country;
    private final int gender;

    public RegistrationRequest(
            @JsonProperty(value = "name", required = true) String name,
            @JsonProperty(value = "email", required = true) String email,
            @JsonProperty(value = "password", required = true) String password,
            @JsonProperty(value = "city", required = true) String city,
            @JsonProperty(value = "country", required = true) String country,
            @JsonProperty(value = "gender", required = true) int gender
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.country = country;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getGender() {
        return gender;
    }
}
