package com.micron.client;

import com.micron.dto.PhotoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "photo-client")
public interface IPhotoClient {

    @GetMapping("/photos")
    public List<PhotoResponseDto> getPhotos();

    @GetMapping("/photos/{id}")
    public PhotoResponseDto getPhotoById(@PathVariable Integer id);
}
