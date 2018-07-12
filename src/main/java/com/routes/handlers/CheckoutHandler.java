package com.routes.handlers;

import com.routes.dto.OrderDTO;
import com.routes.model.Route;
import com.routes.repos.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CheckoutHandler {

    private final JavaMailSender emailSender;
    private final RouteRepository routeRepository;

    @Autowired
    public CheckoutHandler(JavaMailSender emailSender, RouteRepository routeRepository) {
        this.emailSender = emailSender;
        this.routeRepository = routeRepository;
    }

    public Mono<ServerResponse> checkout(ServerRequest request) {
        return request.bodyToMono(OrderDTO.class).flatMap(orderDTO -> {
            Route route = this.routeRepository.findById(Long.valueOf(orderDTO.getRouteId())).get();
            String title = route.getName();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("");
            message.setSubject(title);
            message.setText(orderDTO.getName());
            try {
//            emailSender.send(message);
                return ServerResponse.ok().build();
            } catch (Exception e) {
                return ServerResponse.status(HttpStatus.BAD_REQUEST).build();
            }
        });
    }
}
