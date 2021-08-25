package com.micron.service;

import com.micron.client.ITodoClient;
import com.micron.client.IUserClient;
import com.micron.dto.TodoResponseDto;
import com.micron.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements ITodoService {

    @Autowired
    private ITodoClient todoClient;

    @Override
    public List<TodoResponseDto> getTodos(){
        return todoClient.getTodos();
    }
}
