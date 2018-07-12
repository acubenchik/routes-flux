package com.routes.dto;

import com.routes.model.Guide;
import com.routes.model.Route;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RouteTimeSlotDTO {

    private long id;
    private LocalDateTime availableDate;
    private LocalDateTime endDate;
    private GuideDTO guide;
}
