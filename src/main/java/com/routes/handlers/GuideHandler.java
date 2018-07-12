package com.routes.handlers;

import com.routes.services.GuideService;
import com.routes.services.IGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class GuideHandler {

    private final IGuideService guideService;

    @Autowired
    public GuideHandler(IGuideService guideService) {
        this.guideService = guideService;
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        long guideId = Long.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.status(HttpStatus.NOT_FOUND).build();
        return this.guideService.find(guideId).flatMap(guide ->
                ServerResponse.ok().contentType(APPLICATION_JSON)
                        .body(fromObject(guideService.toDTO(guide)))).switchIfEmpty(notFound);
    }
}
