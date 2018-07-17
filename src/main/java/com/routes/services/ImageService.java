package com.routes.services;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@Component
public class ImageService implements IImageService {

    @Override
    public String getImage(String id) throws IOException {
        InputStream file = getClass().getResourceAsStream("/" + id + ".jpeg");
        return Base64.getEncoder().withoutPadding().encodeToString(IOUtils.toByteArray(file));
    }

}
