package com.neol.images.services;

import com.neol.images.entity.Image;
import com.neol.images.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAllImages(){
        return imageRepository.findAll();
    }

    public void saveImage(Image image){
        imageRepository.save(image);
    }
}
