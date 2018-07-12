package com.routes.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedEntityGraph(name = "AbstractRoute.all",
        attributeNodes = {@NamedAttributeNode("slots")})
@Getter
@Setter
public class Route extends AbstractRoute {

    private String length;
    @Column(length = 1000)
    private String description;

    private String price;

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
//    @Fetch(FetchMode.JOIN) // ignored by spring
    private List<RouteTimeSlot> slots;

    public Route() {
    }
}