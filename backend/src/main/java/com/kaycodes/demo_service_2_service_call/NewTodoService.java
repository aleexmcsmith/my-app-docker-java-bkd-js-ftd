package com.kaycodes.demo_service_2_service_call;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange(accept = "application/json")
public interface NewTodoService {

    @GetExchange(url = "/todos/{id}")
    Todo getTodoById(@PathVariable("id") long id);

    @GetExchange(url = "/todos/?userid={userId}")
    List<Todo> getTodoByUserId(@PathVariable("userId") long userId);

    @GetExchange(url = "/todos")
    List<Todo> getAllTodos();

}
