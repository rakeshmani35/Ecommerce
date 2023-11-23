package com.user.api.exception;

public class UserDoesNotExistException extends Exception {
    public UserDoesNotExistException(String s) {
        super(s);
    }
}
