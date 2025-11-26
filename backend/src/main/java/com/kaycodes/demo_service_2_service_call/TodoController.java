package com.kaycodes.demo_service_2_service_call;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TodoController {
    @Autowired
    private TraditionalTodoService todoService;
    private final NewTodoService newTodoService;

//    public TodoController(NewTodoService newTodoService) {
//        this.newTodoService = newTodoService;
//    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTodo(@PathVariable int id) {
//        try {
        return ResponseEntity.ok(todoService.getDetails(id));
       /* } catch (TodoNotFoundException e) {
            log.info(String.valueOf(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error :: ", e.getMessage(),"name: ","Alexxy"))));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error :: ", e.getMessage(),"name: ","Alexxy"));
        }*/
    }

    @GetMapping("/new/{id}")
    public Todo getTodo(@PathVariable long id) {
        if (newTodoService == null) {
            System.err.println("ERROR: newTodoService is null in getTodo!"); // Temporary debug print
            throw new RuntimeException("NewTodoService bean was not injected!");
        }
        return newTodoService.getTodoById(id);
    }

    @GetMapping("/new-user/{userId}")
    public List<Todo> getTodoByUserId(@PathVariable long userId) {
        if (newTodoService == null) {
            System.err.println("ERROR: newTodoService is null in getTodo!"); // Temporary debug print
            throw new RuntimeException("NewTodoService bean was not injected!");
        }
        return newTodoService.getTodoByUserId(userId);
    }

    @GetMapping("/getall")
    public List<Todo> getAllTodo() {
          return newTodoService.getAllTodos();
    }

}
