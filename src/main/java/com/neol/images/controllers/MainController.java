package com.neol.images.controllers;

import com.neol.images.entity.Image;
import com.neol.images.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

@Controller
public class MainController {

    public static final String UPLOADED = "src/main/resources/static/img";
    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("images", imageService.getAllImages());
        return "main";
    }

    @PostMapping("/upload")
    public String upload(Image image){
        try {
            if (!Files.exists(Path.of(UPLOADED))){
                Files.createDirectory(Path.of(UPLOADED));
            }
            String uploadDir = UPLOADED + "/" + image.getFile().getOriginalFilename();
            Path uploadPath = Paths.get(uploadDir);
            try(InputStream inputStream = image.getFile().getInputStream()){
                Files.copy(inputStream, uploadPath, StandardCopyOption.REPLACE_EXISTING);
            }
            image.setPath("img/" + image.getFile().getOriginalFilename());
            this.imageService.saveImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }


}
