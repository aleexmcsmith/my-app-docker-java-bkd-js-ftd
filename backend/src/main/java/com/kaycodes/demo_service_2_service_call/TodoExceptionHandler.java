package com.kaycodes.demo_service_2_service_call;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;


public class TodoExceptionHandler extends RuntimeException{

    private final int status;
    private final String response;

    public TodoExceptionHandler(String message, int status, String response) {
        super(message);
        this.status = status;
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public int getStatus() {
        return status;
    }
}
