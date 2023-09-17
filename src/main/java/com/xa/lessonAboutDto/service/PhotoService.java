package com.xa.lessonAboutDto.service;

import com.xa.lessonAboutDto.etity.Photo;
import com.xa.lessonAboutDto.repository.PhotoRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PhotoService {

    private final String pathUpload = "C:\\Users\\HP\\Desktop\\upload\\";

    private final PhotoRepository repository;


    public PhotoService(PhotoRepository repository) {
        this.repository = repository;
    }

    public Photo create(MultipartFile file) {

        try {

            String originalName = file.getOriginalFilename();
            String extension = FilenameUtils.getExtension(originalName);
            String generatedName = System.currentTimeMillis() + "." + extension;
            Path path = Paths.get(pathUpload +  generatedName);

            Files.copy((file.getInputStream()), path);

            String url = "http://localhost:8080/api/v1/photo/download/" + generatedName;

            Photo photo = new Photo(
                    null,
                    originalName,
                    generatedName,
                    extension,
                    file.getSize(),
                    path + "",
                    url
            );


            return repository.save(photo);

        } catch (Exception e) {
            return null;
        }




    }

    public Resource download(String generatedName){
        Resource resource = null;

        try {
            Path location = Paths.get(pathUpload + generatedName);
            resource = new UrlResource(location.toUri());
            if (resource.exists() || resource.isReadable()) {

                return resource;

            }
        }catch (Exception e) {
            return null;
        }
        return resource;
    }

}
