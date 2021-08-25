package com.micron.controller;

import com.micron.dto.AlbumResponseDto;
import com.micron.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/micron")
public class AlbumController {

    @Autowired
    private IAlbumService albumService;

    @GetMapping("/albums")
    public List<AlbumResponseDto> getAlbums(){
        return albumService.getAlbums();
    }
}
