package com.example.cj.web01.common;

public class Web01Exception extends RuntimeException {

    public Web01Exception(String message) {
        super(message);
    }

    public Web01Exception(String message, Throwable cause) {
        super(message, cause);
    }
}
