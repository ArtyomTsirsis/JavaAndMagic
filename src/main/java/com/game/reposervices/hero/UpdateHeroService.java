package com.game.reposervices.hero;

import com.game.dto.hero.UpdateHeroRequest;
import com.game.repository.hero.HeroRepository;
import com.game.utils.HeroDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateHeroService {

    @Autowired
    private HeroRepository repository;
    @Autowired
    private HeroDTOConverter converter;

    public void update(UpdateHeroRequest request) {
        if(repository.findById(request.getUpdatedHeroDTO().getName()).isPresent()) {
            repository.update(converter.convertFromDto(request.getUpdatedHeroDTO()));
        }
    }

}
