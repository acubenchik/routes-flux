package com.routes.routes;


import com.routes.dto.GuideDTO;
import com.routes.dto.RouteDTO;
import com.routes.handlers.GuideHandler;
import com.routes.handlers.RouteHandler;
import com.routes.model.Guide;
import com.routes.model.Route;
import com.routes.services.IGuideService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@RunWith(SpringRunner.class)
@WebFluxTest
@ContextConfiguration(classes = {GuideHandlerTests.RouteConfiguration.class, GuideHandler.class})
public class GuideHandlerTests {
    static class RouteConfiguration {
        @Bean
        public RouterFunction<ServerResponse> monoRouterFunction(GuideHandler guideHandler
        ) {
            return route(GET("/guide/get/{id}"), guideHandler::get);
        }
    }


    @MockBean
    private IGuideService guideService;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void itShouldReturnFoundResponseIfGuideFound(){
        long id = 1l;
        Mockito.when(guideService.find(id)).thenReturn(Mono.just(new Guide()));
        Mockito.when(guideService.toDTO(Mockito.any(Guide.class))).thenReturn(new GuideDTO());

        webClient.get().uri("/guide/get/{id}", id).accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk();
    }

    @Test
    public void itShouldReturnNotFoundResponseIfGuideWasNotFound(){
        long id = 1l;
        Mockito.when(guideService.find(id)).thenReturn(Mono.empty());

        webClient.get().uri("/guide/get/{id}", id).accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isNotFound();
    }
}
