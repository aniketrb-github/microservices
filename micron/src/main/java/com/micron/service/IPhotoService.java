package com.micron.service;

import com.micron.dto.PhotoResponseDto;

import java.util.List;

public interface IPhotoService {
    public List<PhotoResponseDto> getAllPhotos();

    public List<PhotoResponseDto> getPhotosByAlbumId(Integer albumId);

    public PhotoResponseDto getPhotoById(Integer id);
}
