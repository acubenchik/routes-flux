package com.routes.handlers;

import com.routes.model.Route;
import com.routes.repos.RouteRepository;
import com.routes.services.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Controller
public class RouteHandler {

    private final IRouteService routeService;

    @Autowired
    public RouteHandler(IRouteService routeService) {
        this.routeService = routeService;
    }

    public Mono<ServerResponse> one(ServerRequest request) {
        long routeId = Long.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.status(HttpStatus.NOT_FOUND).build();
        return Mono.justOrEmpty(this.routeService.findById(routeId)).flatMap(route ->
                ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(routeService.toDTO(route))))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> all(ServerRequest request) {
        Mono<ServerResponse> notFound = ServerResponse.status(HttpStatus.NOT_FOUND).build();
        List<Route> routes = this.routeService.findAll();
        return Flux.fromIterable(routes).collectList().flatMap(route -> {
            if(route.isEmpty()) {
                return notFound;
            }
                return ServerResponse.ok().contentType(APPLICATION_JSON).
                        body(fromObject(routeService.toDTOs(route)));
        }).switchIfEmpty(notFound);
    }
}
