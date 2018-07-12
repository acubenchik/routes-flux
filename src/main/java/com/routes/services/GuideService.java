package com.routes.services;

import com.routes.dto.GuideDTO;
import com.routes.model.Guide;
import com.routes.repos.GuideRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GuideService implements IGuideService {

    private final GuideRepository guideRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public Mono<Guide> find(long id) {
        return Mono.justOrEmpty(guideRepository.findById(id));
    }

    public GuideDTO toDTO(Guide guide) {
        return modelMapper.map(guide, GuideDTO.class);
    }
}
