package com.routes.handlers;

import com.routes.services.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class ImageHandler {

    private final IImageService imageService;

    @Autowired
    public ImageHandler(IImageService imageService) {
        this.imageService = imageService;
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<ServerResponse> image;
        Mono<ServerResponse> notFoundDefault = Mono.empty();
        try {
            Map<String, String> jsonMap = new HashMap<>();
            jsonMap.put("content", imageService.getImage("1"));
            notFoundDefault = ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(jsonMap));
            image = Mono.justOrEmpty(imageService.getImage(id))
                    .flatMap(img -> {
                        jsonMap.put("content", img);
                        return ServerResponse.ok().cacheControl(CacheControl.maxAge(1, TimeUnit.DAYS)).
                                contentType(APPLICATION_JSON).body(fromObject(jsonMap));
                    }).switchIfEmpty(notFoundDefault);
        } catch (IOException e) {
            return notFoundDefault;
        }
        return image;
    }
}
