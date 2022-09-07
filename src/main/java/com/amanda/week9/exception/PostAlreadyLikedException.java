package com.amanda.week9.exception;

public class PostAlreadyLikedException extends RuntimeException{

    private String message;

    public PostAlreadyLikedException(String message) {
        this.message = message;
    }
}
