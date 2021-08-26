package com.micron.service;

import com.micron.client.IAlbumClient;
import com.micron.dto.AlbumResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    private IAlbumClient albumClient;

    @Override
    public List<AlbumResponseDto> getAlbums(){
        return albumClient.getAlbums();
    }

    @Override
    public List<AlbumResponseDto> getAlbumsByUserId(Integer userId) {
        return albumClient.getAlbumsByUserId(userId);
    }

    @GetMapping("/albums/{id}")
    public AlbumResponseDto getAlbumById(@PathVariable Integer id){
        return albumClient.getAlbumById(id);
    }
}
