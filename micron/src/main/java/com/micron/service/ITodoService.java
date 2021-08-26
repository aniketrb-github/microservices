package com.micron.service;

import com.micron.dto.TodoResponseDto;

import java.util.List;

public interface ITodoService {
    public List<TodoResponseDto> getAllTodos();

    public List<TodoResponseDto> getTodosByUserId(Integer userId);

    public TodoResponseDto getTodoById(Integer id);
}
