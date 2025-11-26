package com.kaycodes.demo_service_2_service_call;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

   /* @ExceptionHandler(RestClientResponseException.class)
    public ResponseEntity<String> handlerForRestClientException(RestClientResponseException e){
        return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerForRuntimeException(RuntimeException e){
        return ResponseEntity.status(404).body("alex " + e.getMessage());
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<String> handlerForHttpClientErrorException(HttpClientErrorException e){
        return ResponseEntity.status(404).body("alex " + e.getMessage());
    }*/

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<?> handleTodoNotFound(TodoNotFoundException ex) {
        // You can create a custom error response structure
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMismatchedArgument(MethodArgumentTypeMismatchException ex) {
        // You can create a custom error response structure
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message1", ex.getMessage());
        body.put("message", "Endpoint not found: " + ex.getParameter());
        body.put("url", Arrays.stream(Arrays.stream(ex.getCause().getStackTrace()).toArray()).findFirst());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> handleNoHandlerFound(NoHandlerFoundException ex) {
        // You can create a custom error response structure
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error-type", ex.getClass().getSimpleName());
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Endpoint not found: " + ex.getRequestURL());
        body.put("url", ex.getRequestURL());
        body.put("method", ex.getHttpMethod());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<?> handleWebClientNotFound(WebClientResponseException ex) {
        // You can create a custom error response structure
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error-type", ex.getClass().getSimpleName());
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Endpoint not found: " + ex.getResponseBodyAsString());
        body.put("url", ex.getRequest());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
