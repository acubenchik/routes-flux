package com.routes.services;

import com.routes.dto.RouteDTO;
import com.routes.model.Route;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RouteService implements IRouteService {

    private ModelMapper modelMapper = new ModelMapper();

    public RouteDTO toDTO(Route route) {
        return modelMapper.map(route, RouteDTO.class);
    }

    public List<RouteDTO> toDTOs(List<Route> routes) {
        List<RouteDTO> result = routes.stream().map(this::toDTO).collect(Collectors.toList());
        return result;
    }
}
