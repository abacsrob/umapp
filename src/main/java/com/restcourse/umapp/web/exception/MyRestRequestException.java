package com.restcourse.umapp.web.exception;

public class MyRestRequestException extends RuntimeException {

    public MyRestRequestException() {
        super();
    }

    public MyRestRequestException(String message) {
        super(message);
    }
}
