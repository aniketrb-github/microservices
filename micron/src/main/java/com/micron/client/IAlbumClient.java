package com.micron.client;

import com.micron.dto.AlbumResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "album-client")
public interface IAlbumClient {

    @GetMapping("/albums")
    public List<AlbumResponseDto> getAlbums();

    @GetMapping("/users/{userId}/albums")
    public List<AlbumResponseDto> getAlbumsByUserId(@PathVariable  Integer userId);

    @GetMapping("/albums/{id}")
    public AlbumResponseDto getAlbumById(@PathVariable  Integer id);
}
