package com.micron.controller;

import com.micron.dto.UserResponseDto;
import com.micron.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/micron")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<UserResponseDto> getUsers(){
        return userService.getUsers();
    }
}
