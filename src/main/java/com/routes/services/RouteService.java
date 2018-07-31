package com.routes.services;

import com.routes.dto.RouteDTO;
import com.routes.model.Route;
import com.routes.repos.RouteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RouteService implements IRouteService {

    private final RouteRepository routeRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public RouteService(RouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }

    @Override
    public Optional<Route> findById(Long id) {
        return this.routeRepository.findById(id);
    }

    @Override
    public List<Route> findAll() {
        return this.routeRepository.findAll();
    }

    public RouteDTO toDTO(Route route) {
        return modelMapper.map(route, RouteDTO.class);
    }

    public List<RouteDTO> toDTOs(List<Route> routes) {
        List<RouteDTO> result = routes.stream().map(this::toDTO).collect(Collectors.toList());
        return result;
    }
}
