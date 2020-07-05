package com.mentor.link.model;

public class AuthorizationResponse {

    private final UserResponse user;
    private final String accessToken;

    public AuthorizationResponse(UserResponse user, String accessToken) {
        this.user = user;
        this.accessToken = accessToken;
    }

    public UserResponse getUser() {
        return user;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
