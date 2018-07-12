package com.routes.services;

import com.routes.dto.GuideDTO;
import com.routes.model.Guide;
import reactor.core.publisher.Mono;

public interface IGuideService {
    Mono<Guide> find(long id);

    GuideDTO toDTO(Guide guide);
}
