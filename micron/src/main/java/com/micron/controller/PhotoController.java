package com.micron.controller;

import com.micron.client.IAlbumClient;
import com.micron.client.IPhotoClient;
import com.micron.dto.AlbumResponseDto;
import com.micron.dto.PhotoResponseDto;
import com.micron.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/micron")
public class PhotoController {

    @Autowired
    private IPhotoService photoService;

    @GetMapping("/photos")
    public List<PhotoResponseDto> getPhotos(){
        return photoService.getPhotos();
    }
}
