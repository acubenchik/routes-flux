package com.routes.repos;

import com.routes.model.Route;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RouteRepository extends PagingAndSortingRepository<Route, Long> {

    @EntityGraph(value = "AbstractRoute.all", type = EntityGraph.EntityGraphType.FETCH)
    Iterable<Route> findAll();
}
