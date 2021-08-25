package com.micron.service;

import com.micron.client.IPhotoClient;
import com.micron.dto.PhotoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements IPhotoService {

    @Autowired
    private IPhotoClient photoClient;

    @Override
    public List<PhotoResponseDto> getPhotos(){
        return photoClient.getPhotos();
    }
}
