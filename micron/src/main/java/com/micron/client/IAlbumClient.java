package com.micron.client;

import com.micron.dto.AlbumResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "album-client")
public interface IAlbumClient {

    @GetMapping("/albums")
    public List<AlbumResponseDto> getAlbums();
}
