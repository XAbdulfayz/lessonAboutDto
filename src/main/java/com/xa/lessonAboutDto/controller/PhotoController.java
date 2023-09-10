package com.xa.lessonAboutDto.controller;


import com.xa.lessonAboutDto.etity.Photo;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/photo/")
public class PhotoController {


    @PostMapping("upload/")
    public Photo uploadPhoto(MultipartFile file){

        return null;

    }

    @GetMapping("download/{generatedName}")
    public Resource downloadPhoto(@PathVariable String generatedName){

        return null;
    }


}
