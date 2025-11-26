package com.kaycodes.demo_service_2_service_call;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClient;

import java.util.Arrays;

@Service

public class TraditionalTodoService {
    @Autowired
    private RestClient restClient;

//    private final String URL = "";


    public Todo getDetails(int id) {
        return restClient.get()
                .uri("/todos/"+id)
                .retrieve()
                .onStatus(status-> (status.value() == 404), (request, response) -> {
                    throw new TodoNotFoundException("not found service client error: "+ response.getStatusText());
                })
                /*.onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    String body = Arrays.toString(response.getBody().readAllBytes());
                    throw new TodoExceptionHandler("client error: ", response.getStatusCode().value(),body);
                })*/
                .body(Todo.class);
    }
}
