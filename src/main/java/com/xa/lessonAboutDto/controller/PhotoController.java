package com.xa.lessonAboutDto.controller;


import com.xa.lessonAboutDto.etity.Photo;
import com.xa.lessonAboutDto.service.PhotoService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/photo/")
public class PhotoController {

    private final PhotoService service;

    public PhotoController(PhotoService service) {
        this.service = service;
    }

    @PostMapping("upload/")
    public Photo uploadPhoto(MultipartFile file) {

        return service.create(file);

    }

    @GetMapping("download/{generatedName}")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable String generatedName) {

        Resource file = service.download(generatedName);

        return ResponseEntity.ok().header(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\""
        ).body(file);


    }


}
