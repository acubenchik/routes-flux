package com.routes.services;

import com.routes.dto.RouteDTO;
import com.routes.model.Route;

import java.util.List;
import java.util.Optional;

public interface IRouteService {

    Optional<Route> findById(Long id);
    List<Route> findAll();

    RouteDTO toDTO(Route route);

    List<RouteDTO> toDTOs(List<Route> routes);
}
