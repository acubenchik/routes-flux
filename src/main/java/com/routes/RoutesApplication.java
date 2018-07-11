package com.routes;

import com.routes.handlers.RouteHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class RoutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutesApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction(RouteHandler routeHandler) {
		return route(GET("/route/get/{id}"), routeHandler::one).andRoute(GET("/route/get"), routeHandler::all);
	}
}
