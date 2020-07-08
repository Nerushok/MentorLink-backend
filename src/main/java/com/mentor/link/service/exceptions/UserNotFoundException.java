package com.mentor.link.service.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User isn't found");
    }
}