package com.game.core.repo.hero;

import com.game.dto.hero.UpdateHeroRequest;
import com.game.repository.HeroRepository;
import com.game.utils.HeroDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateHeroService {

    private final HeroRepository repository;
    private final HeroDTOConverter converter;

    public void update(UpdateHeroRequest request) {
        if(repository.findById(request.getUpdatedHeroDTO().getName()).isPresent()) {
            repository.update(converter.convertFromDto(request.getUpdatedHeroDTO()));
        }
    }

}
