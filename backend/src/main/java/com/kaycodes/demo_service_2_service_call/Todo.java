package com.kaycodes.demo_service_2_service_call;


public record Todo(
        long userId,
        long id,
        String title,
        boolean completed) {
}
