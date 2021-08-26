package com.micron.client;

import com.micron.dto.AlbumResponseDto;
import com.micron.dto.TodoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "todo-client")
public interface ITodoClient {

    @GetMapping("/todos")
    public List<TodoResponseDto> getAllTodos();

    @GetMapping("/users/{userId}/todos")
    public List<TodoResponseDto> getTodosByUserId(@PathVariable Integer userId);

    @GetMapping("/todos/{id}")
    public TodoResponseDto getTodoById(@PathVariable Integer id);

}
