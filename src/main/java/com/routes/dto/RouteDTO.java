package com.routes.dto;

import com.routes.model.RouteTimeSlot;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouteDTO {

    private long id;
    private String length;
    private String name;
    private String price;
    private String description;
    private List<RouteTimeSlotDTO> slots;

}
