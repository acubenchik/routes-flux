package com.routes.services;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Component
public class ImageService implements IImageService {

    @Override
    public String getImage(String id) throws IOException {
        File file = new ClassPathResource(id + ".jpeg").getFile();
        return Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(file.toPath()));
    }

    public String getDefaultImage(String id) {
        File file = null;
        try {
            file = new ClassPathResource("default.jpeg").getFile();
            return Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
