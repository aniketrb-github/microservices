package com.micron.service;

import com.micron.dto.AlbumResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IAlbumService {
    public List<AlbumResponseDto> getAlbums();

    public List<AlbumResponseDto> getAlbumsByUserId(Integer userId);

    public AlbumResponseDto getAlbumById(Integer id);
}
