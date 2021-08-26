package com.micron.service;

import com.micron.dto.UserResponseDto;

import java.util.List;

public interface IUserService {

    public List<UserResponseDto> getUsers();

    public UserResponseDto getUserByEmail(String email);
}
