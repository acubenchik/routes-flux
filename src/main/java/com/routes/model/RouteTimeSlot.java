package com.routes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class RouteTimeSlot {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JsonIgnore
    private Route route;

    @ManyToOne
    private Guide guide;

    @Column
    private LocalDateTime availableDate;

    @Column
    private LocalDateTime endDate;

}