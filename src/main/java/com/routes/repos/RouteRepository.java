package com.routes.repos;

import com.routes.model.Route;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RouteRepository extends PagingAndSortingRepository<Route, Long> {

    @EntityGraph(value = "AbstractRoute.all", type = EntityGraph.EntityGraphType.FETCH)
    List<Route> findAll();
}
