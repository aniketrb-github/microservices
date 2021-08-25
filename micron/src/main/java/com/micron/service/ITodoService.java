package com.micron.service;

import com.micron.dto.TodoResponseDto;

import java.util.List;

public interface ITodoService {
    public List<TodoResponseDto> getTodos();
}
