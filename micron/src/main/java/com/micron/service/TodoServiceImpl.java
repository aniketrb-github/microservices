package com.micron.service;

import com.micron.client.ITodoClient;
import com.micron.dto.TodoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private ITodoClient todoClient;

    @Override
    public List<TodoResponseDto> getAllTodos(){
        return todoClient.getAllTodos();
    }

    @Override
    public List<TodoResponseDto> getTodosByUserId(Integer userId) {
        return todoClient.getTodosByUserId(userId);
    }

    @Override
    public TodoResponseDto getTodoById(Integer id) {
        return todoClient.getTodoById(id);
    }
}
