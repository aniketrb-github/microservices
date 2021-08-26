package com.micron.client;

import com.micron.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * FeignClient is used to invoke external 3rd party REST API's
 */
@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "user-client")
public interface IUserClient {

    @GetMapping("/users")
    public List<UserResponseDto> getUsers();

    @GetMapping("/users/{email}")
    public UserResponseDto getUserByEmail(@PathVariable String email);
}
