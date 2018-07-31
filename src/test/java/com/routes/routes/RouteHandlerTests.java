package com.routes.routes;

import com.routes.dto.RouteDTO;
import com.routes.handlers.RouteHandler;
import com.routes.model.Route;
import com.routes.services.IRouteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RunWith(SpringRunner.class)
@WebFluxTest
@ContextConfiguration(classes = {RouteHandlerTests.RouteConfiguration.class, RouteHandler.class})
public class RouteHandlerTests {

	@Configuration
	static class RouteConfiguration{
		@Bean
		public RouterFunction<ServerResponse> monoRouterFunction(RouteHandler routeHandler
		) {
			return route(GET("/route/get/{id}"), routeHandler::one)
					.andRoute(GET("/route/get"), routeHandler::all);
		}
	}

	@Autowired
	private WebTestClient webClient;

	@MockBean
	private IRouteService routeService;

	@Test
	public void itShouldReturnSuccessfullResponseIfRouteWasFound() {
		long id = 1l;
		Mockito.when(routeService.findById(id)).thenReturn(Optional.of(new Route()));
		Mockito.when(routeService.toDTO(Mockito.any(Route.class))).thenReturn(new RouteDTO());

		webClient.get().uri("/route/get/{id}", id).accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk();
	}

	@Test
	public void itShouldReturnNotFoundResponseIfRouteWasNotFound() {
		long id = 1l;
		Mockito.when(routeService.findById(id)).thenReturn(Optional.empty());

		webClient.get().uri("/route/get/{id}", id).accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isNotFound();
	}

	@Test
	public void itShouldReturnNotFoundIfRoutesWereNotFound() {
		Mockito.when(routeService.findAll()).thenReturn(Collections.emptyList());

		webClient.get().uri("/route/get").accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isNotFound();
	}

	@Test
	public void itShouldReturnFoundIfRoutesWereFound() {
		Mockito.when(routeService.findAll()).thenReturn(Arrays.asList(new Route()));

		webClient.get().uri("/route/get").accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk();
	}




}
