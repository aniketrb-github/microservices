package com.micron.client;

import com.micron.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "user-client")
public interface IUserClient {

    @GetMapping("/users")
    public List<UserResponseDto> getUsers();
}
