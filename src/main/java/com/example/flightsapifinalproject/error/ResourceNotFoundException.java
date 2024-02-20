package com.example.blogfinalproject2024.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entityName, String property, Object value) {

        super("Entity %s with %s=%s Not Found".formatted(entityName, property, value));
    }

    public static Supplier<RuntimeException> newInstance(String entityName, String property, Object value) {
        return () -> new ResourceNotFoundException(entityName, property, value);
    }
}