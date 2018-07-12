package com.routes.services;

import com.routes.dto.RouteDTO;
import com.routes.model.Route;

import java.util.List;

public interface IRouteService {

    RouteDTO toDTO(Route route);

    List<RouteDTO> toDTOs(List<Route> routes);
}
