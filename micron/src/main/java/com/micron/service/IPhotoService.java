package com.micron.service;

import com.micron.dto.PhotoResponseDto;

import java.util.List;

public interface IPhotoService {
    public List<PhotoResponseDto> getPhotos();

    public PhotoResponseDto getPhotoById(Integer id);
}
