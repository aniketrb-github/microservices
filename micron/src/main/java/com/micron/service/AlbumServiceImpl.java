package com.micron.service;

import com.micron.client.IAlbumClient;
import com.micron.dto.AlbumResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    private IAlbumClient albumClient;

    @Override
    public List<AlbumResponseDto> getAlbums(){
        return albumClient.getAlbums();
    }
}
