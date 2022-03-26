package com.game.reposervices.hero;

import com.game.utils.HeroDTOConverter;
import com.game.dto.hero.FindAllHeroesResponse;
import com.game.repository.hero.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAllHeroesService {

    @Autowired
    private HeroRepository repository;
    @Autowired
    private HeroDTOConverter converter;

    public FindAllHeroesResponse findAll() {
        return new FindAllHeroesResponse(repository.findAll().stream().map(converter::convertToDto).toList());
    }

}
