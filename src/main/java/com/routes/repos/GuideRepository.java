package com.routes.repos;

import com.routes.model.Guide;
import org.springframework.data.repository.CrudRepository;

public interface GuideRepository extends CrudRepository<Guide, Long> {
}
