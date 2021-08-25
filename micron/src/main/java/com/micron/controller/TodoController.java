package com.micron.controller;

import com.micron.client.IAlbumClient;
import com.micron.client.ITodoClient;
import com.micron.dto.AlbumResponseDto;
import com.micron.dto.TodoResponseDto;
import com.micron.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/micron")
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @GetMapping("/todos")
    public List<TodoResponseDto> getTodos(){
        return todoService.getTodos();
    }
}
