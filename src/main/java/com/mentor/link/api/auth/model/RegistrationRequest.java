package com.mentor.link.api.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationRequest {

    private final String name;
    private final String email;
    private final String password;

    public RegistrationRequest(@JsonProperty("name") String name, @JsonProperty("email") String email, @JsonProperty("password") String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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
}
