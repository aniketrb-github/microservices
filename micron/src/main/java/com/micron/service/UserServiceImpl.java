package com.micron.service;

import com.micron.client.IUserClient;
import com.micron.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserClient userClient;

    @Override
    public List<UserResponseDto> getUsers() {
        return userClient.getUsers();
    }
}
