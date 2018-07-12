package com.routes;

import com.routes.handlers.CheckoutHandler;
import com.routes.handlers.GuideHandler;
import com.routes.handlers.ImageHandler;
import com.routes.handlers.RouteHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class RoutesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoutesApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(RouteHandler routeHandler,
                                                             ImageHandler imageHandler,
                                                             GuideHandler guideHandler,
                                                             CheckoutHandler checkoutHandler) {
        return route(GET("/route/get/{id}"), routeHandler::one)
                .andRoute(GET("/route/get"), routeHandler::all)
                .andRoute(GET("/image/get/{id}"), imageHandler::get)
                .andRoute(GET("/guide/get/{id}"), guideHandler::get)
                .andRoute(POST("/checkout"), checkoutHandler::checkout);
    }
}
