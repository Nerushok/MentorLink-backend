package com.mentor.link.model;

import java.util.UUID;

public class UserResponse {

    private final UUID id;
    private final String name;
    private final String email;

    public UserResponse(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
